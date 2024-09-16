
# Sample Constraints Results

This folder contains the results of rule discovery and assessment for multiple relations using both Rudik and Language Models (LLMs), BERT and ChatGPT. Each file documents the discovered rules and their sensibility evaluations for specific relations.

## Folder Contents:

### 1. **Rules-P101.md**
   - **Description**: Contains the Rudik rule results for relation **P101** (occupation).
   - **Processing**: Rules in this file have been processed using **ChatGPT** to evaluate their sensibility and refine the rules.

### 2. **GenRules-P101_LLM.md**
   - **Description**: Contains rules for relation **P101** generated and refined using **LLMs** (BERT + ChatGPT).
   - **Processing**: Includes the rules processed by BERT, followed by ChatGPT for final assessment and refinement, improving rule specificity and sensibility.

### 3. **Rules-P1412.md**
   - **Description**: Contains the Rudik rule results for relation **P1412** (languages spoken).
   - **Processing**: Rules in this file have been processed using **ChatGPT** to assess their sensibility and improve their clarity.

### 4. **GenRules-P1412_LLM.md**
   - **Description**: Contains rules for relation **P1412** generated and processed using **LLMs** (BERT + ChatGPT).
   - **Processing**: BERT was used to suggest potential class labels, which were then refined by ChatGPT for sensibility assessment and improvement.

### 5. **Rules-P106.md**
   - **Description**: Contains the Rudik rule results for relation **P106** (occupation).
   - **Processing**: ChatGPT was used to process and assess the rules discovered by Rudik for sensibility and logical coherence.

### 6. **GenRules-P106_LLM.md**
   - **Description**: Contains rules for relation **P106** generated and processed using **LLMs** (BERT + ChatGPT).
   - **Processing**: LLMs were used to suggest and refine rules, with ChatGPT providing the final assessment to ensure higher semantic accuracy.

## Details:
- Each file is organized by the specific relation being analyzed (e.g., P101, P1412, P106).
- The **"Rules"** files contain results directly from Rudik, processed through ChatGPT for evaluation.
- The **"GenRules"** files include rules generated and processed by a combination of **BERT** and **ChatGPT**, aiming to enhance rule specificity and overall quality.
