<table border="1">
  <thead>
    <tr>
      <th>Rule</th>
      <th>Description</th>
      <th>Assessment</th>
      <th>Explanation</th>
      <th>Erroneous Triple Count</th>
      <th>Sample Incorrect Triple</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,http://www.wikidata.org/entity/Q6607) & http://www.wikidata.org/prop/direct/P1412(subject,object) => empty set</td>
      <td>Guitar as an occupation</td>
      <td>Sensible</td>
      <td>Guitar is a musical instrument, not a profession, making it invalid as an occupation.</td>
      <td>1</td>
      <td>Libe Garcia de Cortazar (Q29995083) occupation guitar (Q6607) </td>
    </tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,http://www.wikidata.org/entity/Q9301) & http://www.wikidata.org/prop/direct/P1412(subject,object) => empty set</td>
      <td>Serbo-Croatian as an occupation</td>
      <td>Sometimes Sensible</td>
      <td>Serbo-Croatian is a language, which does not correspond to an occupation. It could be sometimes sensible choice, as it would generally flag errors but might occasionally capture valid cases depending on how certain datasets are structured.</td>
      <td>0</td>
      <td>-</td>
    </tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,http://www.wikidata.org/entity/Q9798) & http://www.wikidata.org/prop/direct/P1412(subject,object) => empty set</td>
      <td>Saxophone as an occupation</td>
      <td>Sensible</td>
      <td>Saxophone is a musical instrument, not a profession, making it invalid as an occupation.</td>
      <td>0</td>
      <td>-</td>
    </tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,http://www.wikidata.org/entity/Q5994) & http://www.wikidata.org/prop/direct/P1412(subject,object) => empty set</td>
      <td>Piano as an occupation</td>
      <td>Sensible</td>
      <td>Piano is a musical instrument, not a profession, making it invalid as an occupation.</td>
      <td>1</td>
      <td>Libe Garcia de Cortazar (Q29995083) occupation piano (Q5994)</td>
    </tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,http://www.wikidata.org/entity/Q165192) & http://www.wikidata.org/prop/direct/P1412(subject,object) => empty set</td>
      <td>Swedes as an occupation</td>
      <td>Sometimes Sensible</td>
      <td>Swedes is a nationalitiy, which does not correspond to an occupation. It could be sometimes sensible choice, as it would generally flag errors but might occasionally capture valid cases depending on how certain datasets are structured.</td>
      <td>0</td>
      <td>-</td>
    </tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,http://www.wikidata.org/entity/Q1298934) & http://www.wikidata.org/prop/direct/P1412(subject,object) => empty set</td>
      <td>Synth-pop as an occupation</td>
      <td>Sensible</td>
      <td>Synth-pop is a musical genre, not a profession, making it invalid as an occupation.</td>
      <td>0</td>
      <td>-</td>
    </tr>
  </tbody>
</table>
