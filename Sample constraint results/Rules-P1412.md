<table>
  <thead>
    <tr>
      <th>Rule</th>
      <th>Description</th>
      <th>Assessment</th>
      <th>Explanation</th>
      <th>Erroneous Triple Count</th>
      <th>Sample Incorrect Wikidata Triple</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><strong>1</strong></td>
      <td><code>P69(subject, v0) (educated at) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Not Sensible</strong></td>
      <td>A person can be educated at an institution and speak a language without contradiction. This rule would incorrectly flag valid triples.</td>
      <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>2</strong></td>
      <td><code>P31(subject, v0) (instance of) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Not Sensible</strong></td>
      <td>Being an instance of a class (e.g., human) and speaking a language are not mutually exclusive. This rule would incorrectly flag valid triples.</td>
      <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>3</strong></td>
      <td><code>P20(subject, v0) (place of death) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Sometimes Sensible</strong></td>
      <td>While someone can have a place of death and speak a language, this rule might make sense in rare cases where language and death circumstances conflict.</td>
      <td>Manual Inspection - Wrong GPT Labelling</td>
      <td>Not Sensible</td>
    </tr>
    <tr>
      <td><strong>4</strong></td>
      <td><code>P106(subject, v0) (occupation) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Not Sensible</strong></td>
      <td>Having an occupation and speaking a language are not mutually exclusive and often occur together.</td>
      <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>5</strong></td>
      <td><code>P31(subject, Q5) (human) & P31(object, Q5) (human) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Sensible</strong></td>
      <td>It doesn’t make sense for one human to be the language spoken by another human. This rule correctly flags erroneous triples.</td>
      <td> >100 </td>
      <td>Nicolas Defuisseaux (Q15879794) languages spoken, written or signed Fernand Defuisseaux (Q3069112)</td>
    </tr>
    <tr>
      <td><strong>6</strong></td>
      <td><code>P1412(subject, v0) (languages spoken) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Sensible</strong></td>
      <td>A subject cannot speak two instances of the same language or duplicate the same language. This rule correctly flags erroneous triples.</td>
      <td>Manual Inspection - Wrong GPT Labelling</td>
      <td>Not Sensible</td>
    </tr>
    <tr>
      <td><strong>7</strong></td>
      <td><code>P19(subject, v0) (place of birth) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Not Sensible</strong></td>
      <td>A person’s place of birth and the language they speak are not mutually exclusive. This rule would incorrectly flag valid triples.</td>
      <td>-</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>8</strong></td>
      <td><code>P31(object, v0) (instance of) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Sometimes Sensible</strong></td>
      <td>If the object is not something that can be a spoken language, this rule makes sense, but it could flag valid triples based on object type.</td>
      <td>0</td>
      <td>-</td>
    </tr>
    <tr>
      <td><strong>9</strong></td>
      <td><code>P27(subject, v0) (nationality) & P1412(subject, object) (languages spoken) => empty set</code></td>
      <td><strong>Not Sensible</strong></td>
      <td>Having a nationality and speaking a language are not mutually exclusive. This rule would incorrectly flag valid triples.</td>
      <td>-</td>
      <td>-</td>
    </tr>
  </tbody>
</table>
