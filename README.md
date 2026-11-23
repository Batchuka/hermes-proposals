# hermes-proposals

The proposals service of [Hermes](https://github.com/Batchuka/spec-hermes), a demo of an equipment financing process. It registers a financing proposal and its documents (the equipment invoice, proof of income).

Each document type has a different shape, so proposals live in **MongoDB**.

| | |
| --- | --- |
| Database | MongoDB, database `proposals` |
| Starts with | UC-01: register a proposal with its documents (#1) |

## Run locally

Start MongoDB first ([hermes-infra](https://github.com/Batchuka/hermes-infra), folder `local`). Then:

```powershell
./mvnw spring-boot:run
```

## Work

Issues and versions are on the [Hermes project](https://github.com/users/Batchuka/projects/13). The workflow is in [spec-hermes](https://github.com/Batchuka/spec-hermes/blob/main/WORKFLOW.md).
