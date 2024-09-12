<table border="1">
  <thead>
    <tr>
      <th>Rule</th>
      <th>Assessment</th>
      <th>Explanation</th>
<th>Erroneous Triple Count</th>
      <th>Sample Incorrect Wikidata Triple</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P31(subject,v0) & http://www.wikidata.org/prop/direct/P106(subject,object) => empty set</td>
      <td>Sensible</td>
      <td>This rule flags cases where an entity (subject) has an occupation (P106) but also an undefined instance type (P31). This is a valid restriction because the subject's instance type should not be vague when an occupation is assigned.</td>
    <td>-</td>
      <td>-</td>    
</tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P106(subject,v0) & http://www.wikidata.org/prop/direct/P106(subject,object) => empty set</td>
      <td>Not Sensible</td>
      <td>This rule prevents a subject from having multiple occupations (P106), which is incorrect, as many people have more than one occupation (e.g., an actor who is also a director). This rule would erroneously flag valid triples.</td>
    <td>-</td>
      <td>-</td>   
</tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P31(subject,http://www.wikidata.org/entity/Q5) & http://www.wikidata.org/prop/direct/P31(object,http://www.wikidata.org/entity/Q5) & http://www.wikidata.org/prop/direct/P106(subject,object) => empty set</td>
      <td>Sensible</td>
      <td>This rule invalidates a relationship where both the subject and the object are humans (instance of Q5) and one human is assigned as the occupation of the other. It is sensible because a human cannot be the occupation of another human.</td>
    <td>0</td>
      <td>0</td>    
</tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P31(object,v0) & http://www.wikidata.org/prop/direct/P106(subject,object) => empty set</td>
      <td>Sometimes Sensible</td>
      <td>This rule invalidates a subject having an occupation (P106) where the object has an undefined instance type (P31). While this can flag erroneous triples, there might be cases where the instance type is implied or not essential, making the rule overly restrictive.</td>
    <td>-</td>
      <td>-</td>    
</tr>
    <tr>
      <td>http://www.wikidata.org/prop/direct/P27(subject,v0) & http://www.wikidata.org/prop/direct/P106(subject,object) => empty set</td>
      <td>Not Sensible</td>
      <td>This rule invalidates a subject having both a nationality (P27) and an occupation (P106). Since there is no inherent conflict between these two properties, the rule would incorrectly flag valid triples.</td>
    <td>-</td>
      <td>-</td>    
</tr>
  </tbody>
</table>
