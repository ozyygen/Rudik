<table border="1">
  <tr>
    <th>Rule</th>
    <th>Classification</th>
    <th>Explanation</th>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P551(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Sensible</td>
    <td>Residence (P551) and instance of human (Q5) are unrelated. Humans (Q5) typically have a residence, so this rule is sensible for catching erroneous triples.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P737(v0,subject) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Not Sensible</td>
    <td>"Influenced by" (P737) could easily relate to humans (Q5), particularly in cultural or intellectual contexts. This rule may flag valid triples, making it not sensible.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P26(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Not Sensible</td>
    <td>Marriage (P26) is a valid relationship for humans (Q5). This rule would flag correct relationships, making it not sensible.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P108(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Sensible</td>
    <td>Employer (P108) and being a human (Q5) are unrelated in a direct way. This rule is sensible because it detects incorrect triples linking humans and employers.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P136(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Sometimes Sensible</td>
    <td>Genre (P136) can be associated with humans, especially in creative fields. However, there are cases where this rule could catch errors. Sometimes sensible.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P20(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Sensible</td>
    <td>Place of death (P20) and being a human (Q5) are unrelated in this rule’s context. This rule sensibly flags invalid triples.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P106(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Sometimes Sensible</td>
    <td>Occupation (P106) is a valid relation for humans (Q5), but errors in occupation assignments can occur, making this rule sometimes sensible.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P1412(v0,object) & http://www.wikidata.org/prop/direct/P31(object,Q34770) => empty set</td>
    <td>Sensible</td>
    <td>Languages spoken (P1412) should not be confused with the "instance of language" classification (Q34770). This rule sensibly flags incorrect relationships between languages and classification.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P40(v0,subject) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Not Sensible</td>
    <td>Parent-child (P40) relationships are valid for humans (Q5). This rule would flag valid relationships, making it not sensible.</td>
  </tr>
  <tr>
    <td>http://www.wikidata.org/prop/direct/P1050(subject,v0) & http://www.wikidata.org/prop/direct/P31(subject,Q5) => empty set</td>
    <td>Sensible</td>
    <td>Medical conditions (P1050) and being a human (Q5) are unrelated in this context. This rule sensibly flags incorrect triples.</td>
  </tr>
</table>
