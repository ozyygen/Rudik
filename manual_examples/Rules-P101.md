<table>
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
      <td><strong>1</strong></td>
      <td>http://www.wikidata.org/prop/direct/P101(subject,object) & http://www.wikidata.org/prop/direct/P31(subject,http://www.wikidata.org/entity/Q5) => empty set</td>
      <td><strong>Not Sensible</strong></td>
      <td>This rule states that if a subject (a human, P31 instance of Q5) has a field of work (P101), it is invalid. However, humans can have fields of work, such as "physicist" or "artist," so this rule would incorrectly flag valid triples.</td>
   <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>2</strong></td>
      <td>http://www.wikidata.org/prop/direct/P101(subject,object) & http://www.wikidata.org/prop/direct/P106(subject,v0) => empty set</td>
      <td><strong>Sometimes Sensible</strong></td>
      <td>This rule prevents a subject from having both a field of work (P101) and an occupation (P106). In some cases, these could be redundant or contradictory, but in others, they might be complementary (e.g., someone working in "education" and having the occupation "teacher").</td>
         <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>3</strong></td>
      <td>http://www.wikidata.org/prop/direct/P101(subject,object) & http://www.wikidata.org/prop/direct/P31(subject,http://www.wikidata.org/entity/Q5) & http://www.wikidata.org/prop/direct/P31(object,http://www.wikidata.org/entity/Q5) => empty set</td>
      <td><strong>Sensible</strong></td>
      <td>This rule invalidates a relationship between two humans where one is the field of work of the other. It is sensible because a person cannot be the field of work for another person, and such triples would be incorrect.</td>
       <td>0</td>
      <td>0</td>
    </tr>
    <tr>
      <td><strong>4</strong></td>
      <td>http://www.wikidata.org/prop/direct/P101(subject,v0) & http://www.wikidata.org/prop/direct/P101(subject,object) => empty set</td>
      <td><strong>Not Sensible</strong></td>
      <td>This rule states that if a subject has two fields of work, it is invalid. However, many people have multiple fields of work (e.g., someone working in both "medicine" and "teaching"), so this rule would falsely flag many valid triples.</td>
    <td></td>
      <td></td>
    </tr>
    <tr>
      <td><strong>5</strong></td>
      <td>http://www.wikidata.org/prop/direct/P1412(subject,v0) & http://www.wikidata.org/prop/direct/P101(subject,object) => empty set</td>
      <td><strong>Sometimes Sensible</strong></td>
      <td>This rule prevents a subject from having both a language spoken (P1412) and a field of work (P101). It is sometimes sensible, as the rule might target specific inconsistencies, but it can also flag valid triples since there is no inherent conflict between speaking a language and having a field of work.</td>
      <td>0</td>
      <td>0</td>
    </tr>
    <tr>
      <td><strong>6</strong></td>
      <td>http://www.wikidata.org/prop/direct/P31(object,v0) & http://www.wikidata.org/prop/direct/P101(subject,object) => empty set</td>
      <td><strong>Sometimes Sensible</strong></td>
      <td>This rule invalidates relationships between a subject and an object if the object has a specific type (P31). Depending on the specific type, this might make sense (e.g., a "musician" shouldn't have a "language" as their field of work), but there are cases where the object type and field of work could coexist.</td>
            <td>0</td>
      <td>0</td>
    </tr>
    <tr>
      <td><strong>7</strong></td>
      <td>http://www.wikidata.org/prop/direct/P27(subject,v0) & http://www.wikidata.org/prop/direct/P101(subject,object) => empty set</td>
      <td><strong>Not Sensible</strong></td>
      <td>This rule invalidates a person having both a nationality (P27) and a field of work (P101). These two properties are not mutually exclusive and are commonly found together (e.g., a "German" physicist), so the rule would incorrectly flag many valid triples.
            <td>-</td>
      <td>-</td>
      </td>
    </tr>
  </tbody>
</table>
