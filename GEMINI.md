# Project: LINE Bot RPG Assistant

## Directory Overview

This directory contains a set of scripts and configuration files for interacting with the Gemini CLI (`gemini`). The primary purpose is to set up a specific context for the AI to act as either a game designer or a programmer to assist in the development of a LINE Bot-based RPG. The game's concept and specifications are detailed in `spec.md`.

## Key Files

*   **`spec.md`**: The core design document for the LINE Bot RPG. It outlines game mechanics like registration, combat, crafting, and quests. This file serves as the foundational knowledge for the project.
*   **`myGemini.bat`**: The main entry point script. It prompts the user to select a persona (game designer or programmer), loads the corresponding role and rules, and then launches the `gemini` CLI with that context.
*   **`roles/`**: This directory contains the persona definitions for the AI.
    *   `role_gamer.txt`: Instructs the AI to act as a senior game designer.
    *   `role_programmer.txt`: Instructs the AI to act as a senior programmer.
*   **`rules/rules.txt`**: Contains a set of rules that the AI must follow during the interaction.

## Usage

To start an interactive session with the AI assistant, run the `myGemini.bat` script:

```bash
myGemini.bat
```

You will be prompted to choose a character:

1.  **Game Designer:** Select this to get help with game design concepts, balancing, and mechanics based on the `spec.md`.
2.  **Programmer:** Select this to get help with technical implementation, code examples, and architecture for the LINE Bot game.

The script will then launch the Gemini CLI with the appropriate persona and rule set, ready for your questions.