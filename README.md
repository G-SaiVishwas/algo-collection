# Algo Collection

Welcome to Algo Collection, a Hacktoberfest 2025 friendly space for learning algorithms and the GitHub workflow. Every contribution covers exactly **one** algorithm in exactly **one** programming language, plus a quick note in our contributors log.

## Quick Start
- Follow me and ⭐ Star this repo first—it keeps you on the Hacktoberfest leaderboard and helps others discover us.
- Read the flow below before coding anything.
- Grab or open an issue for a single algorithm/language pair.
- Follow the naming rules, add your code, and register yourself in `contributors.json`.
- Open a PR that links your issue and passes the checklist.

## Contribution Flow
1. **Star the repo**: Click the ⭐ button at the top of the page. We track stars to highlight active contributors, and it is the first requirement before any contribution.
2. **Look for existing issues**: Use the Issues tab to search for the algorithm and language you want to implement. Filter by open issues to avoid duplicates.
3. **Raise a new issue (if needed)**:
	- Ensure nobody else has already opened the same algorithm/language request.
	- Use the title format `[Language] Algorithm Name` (for example, `[Python] Binary Search`).
	- In the issue body, include: short description, expected input/output, and any reference links.
	- Only request one algorithm in one language per issue.
4. **Get assigned**: Comment on the issue asking to be assigned. Wait until a maintainer assigns you before starting work.
5. **Fork the repository**: Click **Fork** on GitHub to create your copy under your account.
6. **Clone your fork**:
	```bash
	git clone https://github.com/<your-username>/algo-collection.git
	cd algo-collection
	```
7. **Sync with upstream** (recommended before each new task):
	```bash
	git remote add upstream https://github.com/G-SaiVishwas/algo-collection.git
	git fetch upstream
	git checkout main
	git merge upstream/main
	```
8. **Create a feature branch**:
	```bash
	git checkout -b feature/<language>-<algorithm-name>
	```
	Example: `feature/python-binary-search`.
9. **Write your algorithm** inside the correct language folder (see structure below).
10. **Add yourself to `contributors.json`** by appending a new entry with your name, the algorithm, language, and file path (format shown later in this document).
11. **Commit your work** with a clear message:
    ```bash
    git add <paths-you-changed>
    git commit -m "Add <Algorithm Name> in <Language>"
    ```
12. **Push and open a PR**:
    ```bash
    git push origin feature/<language>-<algorithm-name>
    ```
    Open a pull request against `main`, link the original issue, and fill in the PR checklist.

## Repository Structure
Algorithms live inside language-specific folders. Add new files to the correct directory (each folder includes a couple of starter examples to demonstrate the expected format):

```
algo-collection/
├── c/
├── cpp/
├── go/
├── java/
├── javascript/
├── python/
├── rust/
├── swift/
└── typescript/
```

Feel free to suggest additional languages by opening an issue first so we can create the folder together.

## `contributors.json` Format
- The file lives at the repo root and starts as an empty JSON array: `[]`.
- Append **one** object per contributor and keep existing entries intact.
- Sample entry (replace values with your details):

```json
[
	{
		"name": "Your Name",
		"algorithm": "Binary Search",
		"language": "Python",
		"file": "python/binary_search.py"
	}
]
```

If entries already exist, place your object just before the closing `]` and add a comma after the previous entry.

## File Naming Rules
- Use lowercase letters, hyphens, or underscores: `algorithm-name.ext` (examples: `binary-search.py`, `merge_sort.java`).
- One file per algorithm implementation.
- Include a short header comment describing the algorithm, expected input/output, and time complexity where possible.
- Place helper classes or test code in the same file unless the language requires otherwise (open an issue to discuss exceptions).
- Do not duplicate an algorithm that already exists in the same language; improve the existing one instead by discussing in the issue.

## Coding Guidelines
- Keep implementations simple and educational. Prioritize readability over micro-optimizations.
- Add inline comments only when logic is non-obvious. Keep them concise.
- Use standard library features whenever available.
- Include a minimal usage example or a `main`/`driver` function that demonstrates the algorithm.
- Ensure the code compiles or runs without additional dependencies.

## Pull Request Checklist
- [ ] I starred this repository before contributing.
- [ ] My issue title follows `[Language] Algorithm Name`.
- [ ] My PR references the issue number (for example, `Closes #12`).
- [ ] I follow G-SaiVishwas, and I have starred the repository.
- [ ] Only one algorithm implementation is included in this PR.
- [ ] File naming follows the prescribed pattern and resides in the correct language folder.
- [ ] I added my details to `contributors.json` in the required format.
- [ ] I tested the code locally (compile/run as applicable).

## Reviews and Merges
- Maintainers will review PRs in the order issues were assigned.
- Requested changes must be addressed within 7 days to keep the PR active.
- Once approved, maintainers will merge the PR and label it for Hacktoberfest 2025 participation.

## Need Help?
- Open a new issue with the `question` label.
- Join the discussion on existing issues to learn from other contributors.
- Check the GitHub Discussions tab (coming soon) for FAQs, setup guides, and study resources.

Thank you for contributing and helping beginners grow through open source. Remember: star the repo, raise an issue, follow the rules, and enjoy building the Algo Collection together!
