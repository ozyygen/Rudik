package asu.edu.rule_miner.rudik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.jena.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import com.google.common.collect.Sets;

import asu.edu.rule_miner.rudik.configuration.ConfigurationFacility;
import asu.edu.rule_miner.rudik.model.horn_rule.HornRule;
import asu.edu.rule_miner.rudik.model.statistic.StatisticsContainer;
import asu.edu.rule_miner.rudik.rule_generator.DynamicPruningRuleDiscovery;

public class App {
	private final static Logger LOGGER = LoggerFactory.getLogger(App.class.getName());
	public static ResultSet executeSparqlQuery(String queryStr) {
		Query query = QueryFactory.create(queryStr);
		try (QueryExecution qexec = QueryExecutionFactory.sparqlService("http://localhost:7200/repositories/personWikidata", query)) {
			return qexec.execSelect();
		}
	}
	public static void main(String[] args) {
		try {
			// Load configuration using ConfigurationFacility
			ConfigurationFacility.setConfigurationFile("src/main/config/Configuration.xml");
			org.apache.commons.configuration.Configuration config = ConfigurationFacility.getConfiguration();

			// Log configuration details for troubleshooting
			LOGGER.info("Loaded configuration: {}", config);

			// Extract configurations
			String typeQuery = "";
			Set<String> relations = Sets.newHashSet("http://www.wikidata.org/prop/direct/P1303");
			String targetRelation = "http://www.wikidata.org/prop/direct/P1303";
			String typePrefix = "http://www.wikidata.org/prop/direct/P31";
			typeQuery +=

					"SELECT ?subjectType ?objectType (COUNT(*) AS ?count) WHERE { " +
							" ?subject <" + targetRelation + "> ?object. " +
							" ?object <" + typePrefix + "> ?objectType. " +
							" ?subject <" + typePrefix + "> ?subjectType. " +
							"} GROUP BY ?subjectType ?objectType " +
							"ORDER BY DESC(?count) LIMIT 1";

			System.out.println("Type query started" + typeQuery);
			// Execute the typeQuery
			ResultSet resultSet = executeSparqlQuery(typeQuery);
			System.out.println("Type query ended");
			// Initialize the type variables
			String typeSubject = null;
			String typeObject = null;

			int count = 0;
			while (resultSet.hasNext()) {
				QuerySolution solution = resultSet.nextSolution();

				typeSubject = solution.getResource("subjectType").toString();
				typeObject = solution.getResource("objectType").toString();
			}


			LOGGER.info("Using SPARQL endpoint: {}", config.getString("naive.sparql.parameters.sparql_endpoint"));
			LOGGER.info("Using graph IRI: {}", config.getString("naive.sparql.graph_iri"));

			int limitSubject = config.getInt("naive.sparql.limits.edges.subject", -1);
			int limitObject = config.getInt("naive.sparql.limits.edges.object", -1);
			int positiveLimit = config.getInt("naive.sparql.limits.examples.positive", 1000);
			int negativeLimit = config.getInt("naive.sparql.limits.examples.negative", 1000);
			double alpha = config.getDouble("naive.runtime.score.alpha", 0.3);
			double beta = config.getDouble("naive.runtime.score.beta", 0.7);
			double gamma = config.getDouble("naive.runtime.score.gamma", 0.1);
			double subWeight = 0.5;
			double objWeight = 0.5;
			boolean isTopK = false;

			DynamicPruningRuleDiscovery naive = new DynamicPruningRuleDiscovery();
			StatisticsContainer.setFileName(new File("statisticsFile"));

			naive.setSubjectLimit(limitSubject);
			naive.setObjectLimit(limitObject);
			naive.setGenerationSmartLimit(-1); // assuming genLimit is not explicitly mentioned in the provided config
			naive.setSmartWeights(alpha, beta, gamma, subWeight, objWeight);
			naive.setIsTopK(isTopK);

			String id = relations + "_" + limitSubject + "_" + limitObject + "_" + positiveLimit + "_" + negativeLimit + "_" + -1 + "_" + alpha
					+ "_" + beta + "_" + gamma + "_" + isTopK;
			StatisticsContainer.initialiseContainer(id);

			Set<Pair<String, String>> negativeExamples;
			if (negativeLimit == -1) {
				negativeExamples = naive.generateNegativeExamples(relations, typeSubject, typeObject);
				//writeNegativesToFile(negativeExamples, "negativeExamples");
			} else {
				negativeExamples = naive.generateNegativeExamples(relations, typeSubject, typeObject, negativeLimit);
				//writeNegativesToFile(negativeExamples, "negativeExamples");
			}

			Set<Pair<String, String>> positiveExamples;
			if (positiveLimit == -1)
				positiveExamples = naive.generatePositiveExamples(relations, typeSubject, typeObject);
			else
				positiveExamples = naive.generatePositiveExamples(relations, typeSubject, typeObject, positiveLimit);

			Map<HornRule, Double> discoveredNegativeRulesMap = naive.discoverAllNegativeHornRules(negativeExamples, positiveExamples, relations, typeSubject, typeObject, -1);
			List<HornRule> discoveredNegativeRules = discoveredNegativeRulesMap.keySet().stream().collect(Collectors.toList());

			Map<HornRule, Double> discoveredPositiveRulesMap = naive.discoverAllPositiveHornRules(negativeExamples, positiveExamples, relations, typeSubject, typeObject, -1);
			List<HornRule> discoveredPositiveRules = discoveredPositiveRulesMap.keySet().stream().collect(Collectors.toList());

			// Write discovered rules to files
			writeRulesToFile(discoveredNegativeRulesMap, "negative_horn_rules.txt");
			writeRulesToFile(discoveredPositiveRulesMap, "positive_horn_rules.txt");

			StatisticsContainer.printStatistics();

		} catch (Exception e) {
			LOGGER.error("An error occurred while executing the rule discovery process", e);
			e.printStackTrace();
		}
	}

	private static void writeRulesToFile(Map<HornRule, Double> rules, String fileName) {
		if (rules == null || rules.isEmpty()) {
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Map.Entry<HornRule, Double> entry : rules.entrySet()) {
				HornRule rule = entry.getKey();
				Double score = entry.getValue();
				writer.write("Rule: " + rule.toString() + " | Score: " + score);
				writer.newLine();
			}
		} catch (IOException e) {
			LOGGER.error("Failed to write rules to file: {}", fileName, e);
		}
	}

	private static void writeNegativesToFile(Set<Pair<String, String>> negativeExamples, String fileName) {
		if (negativeExamples == null || negativeExamples.isEmpty()) {
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			for (Pair<String, String> pair : negativeExamples) {
				String subject = pair.getLeft();  // or getKey()
				String object = pair.getRight();  // or getValue()

				writer.write(subject + " " + object);  // Write the subject-object pair to the file
				writer.newLine();  // Move to the next line
			}
		} catch (IOException e) {
			LOGGER.error("Failed to write negative examples to file: {}", fileName, e);
		}
	}


}
