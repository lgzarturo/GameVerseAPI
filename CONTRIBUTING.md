# Contributing to GameVerse API 🎮

Thank you for your interest in contributing to GameVerse API! This document provides guidelines and recommendations for contributing to the project. There are many ways to help, and we appreciate all contributions.

## 📑 Table of Contents

- [Ways to Contribute](#ways-to-contribute)
- [Community Roles](#community-roles)
- [Contribution Process](#contribution-process)
- [Style Guidelines](#style-guidelines)
- [Issue Reporting](#issue-reporting)
- [Pull Requests](#pull-requests)
- [Code of Conduct](#code-of-conduct)

## 💡 Ways to Contribute

### 1. Documentation
- Fix spelling and grammar errors
- Improve existing explanations
- Add usage examples
- Translate documentation
- Update README and wikis

### 2. Issues and Suggestions
- Report bugs
- Suggest new features
- Propose performance improvements
- Share ideas for new modules
- Report security issues

### 3. Code
- Fix existing bugs
- Implement new features
- Optimize existing code
- Add tests
- Improve test coverage

### 4. Community
- Answer questions in issues
- Help other contributors
- Share the project
- Write articles or tutorials
- Give talks about the project

### 5. Content
- Contribute gaming data
- Verify and validate existing information
- Keep data up to date
- Suggest improvements to data structure

## 👥 Community Roles

### Available Roles
1. **Contributor**: Anyone who contributes to the project
2. **Moderator**: Helps keep discussions productive
3. **Editor**: Verifies and validates gaming content
4. **Reviewer**: Reviews pull requests
5. **Maintainer**: Helps manage the project

### How to Obtain Roles
- Start by contributing regularly
- Demonstrate knowledge and commitment
- Follow project guidelines
- Maintain a positive and collaborative attitude
- Apply for the role when you feel ready

## 🔄 Contribution Process

### 1. Preparation
```bash
# Fork the repository
git clone https://github.com/YOUR-USERNAME/GameVerseAPI.git
cd GameVerseAPI
git remote add upstream https://github.com/original/GameVerseAPI.git

# Create branch for your contribution
git checkout -b feature/your-feature
```

### 2. Development
- Write clean, maintainable code
- Add tests when necessary
- Follow style guidelines
- Document changes
- Make small, meaningful commits

### 3. Submission
```bash
# Update your fork
git fetch upstream
git rebase upstream/main

# Push your changes
git push origin feature/your-feature
```

### 4. Pull Request
- Clearly describe the changes
- Reference related issues
- Include screenshots if applicable
- Respond to comments
- Update based on feedback

## 📝 Style Guidelines

### Java Code
```java
// Code style example
public class GameController {
    private final GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getGame(@PathVariable Long id) {
        // Implementation
    }
}
```

### Commits
```bash
# Commit format
<type>(<scope>): <description>

# Examples
feat(games): add genre search endpoint
fix(auth): correct JWT token validation
docs(readme): update installation instructions
```

## 🐛 Issue Reporting

### Bug Template
```markdown
**Description:**
[Clear and concise bug description]

**Steps to Reproduce:**
1. [First step]
2. [Second step]
3. [And so on...]

**Expected Behavior:**
[What should happen]

**Actual Behavior:**
[What is happening]

**Screenshots:**
[If applicable]

**Environment:**
- OS: [e.g. Windows 10]
- Java Version: [e.g. 21]
- Spring Boot Version: [e.g. 3.3.5]
```

### Feature Template
```markdown
**Feature Description:**
[Detailed description]

**Use Case:**
[How and when it would be used]

**Benefits:**
- [Benefit 1]
- [Benefit 2]

**Suggested Implementation:**
[Initial implementation ideas]
```

## 🤝 Pull Requests

### PR Checklist
- [ ] Tests added/updated
- [ ] Documentation updated
- [ ] Code follows style guidelines
- [ ] All tests pass
- [ ] No conflicts with main

### Review Process
1. Automated review (GitHub Actions)
2. Code review by maintainers
3. Discussion and feedback
4. Approval and merge

## 📜 Code of Conduct

We are committed to:
- Being respectful and patient
- Accepting constructive criticism
- Focusing on what's best for the community
- Showing empathy towards other contributors

### Unacceptable Behavior
- Use of offensive language
- Trolling or insulting comments
- Public or private harassment
- Publishing others' private information
- Unprofessional conduct

## 📢 Contact

Questions? Suggestions? Need help?
- GitHub Issues: [Create Issue](https://github.com/lgzarturo/GameVerseAPI/issues)
- Email: lzgarturo@gmail.com
- Discussions: [Forum](https://github.com/lgzarturo/GameVerseAPI/discussions)
- Project Wiki: [Documentation](https://github.com/lgzarturo/GameVerseAPI/wiki)

---

Thank you for making GameVerse API a better project! ❤️
