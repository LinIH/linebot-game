# Directory Overview

This directory contains the design and planning documents for a text-based RPG game. It is a non-code project focused on defining the game's mechanics, features, and data structure before development begins. The project is in the planning phase, with key documents outlining the game's specification and database schema.

## Key Files

*   **`spec.md`**: This is the core game design document. It provides a detailed specification of the game's features, including the core gameplay loop, player attributes, exploration and combat systems, crafting, daily missions, and a player-driven market. It serves as the primary reference for the game's functionality.
*   **`TableSchema.md`**: This file outlines the database schema for the game. It defines the tables required to store game data, such as `Players`, `Items`, `Monsters`, and `Market`. Each table definition is currently a placeholder, indicating that the detailed SQL schema is yet to be written.

## Usage

This directory is intended to be used as a central hub for game design and planning. The documents within it should be maintained and updated as the game's design evolves. The intended workflow is as follows:

1.  **Game Design**: Define and refine game mechanics and features in `spec.md`.
2.  **Database Design**: Based on the game design, define the necessary data structures and relationships in `TableSchema.md`.
3.  **Development**: Use `spec.md` and `TableSchema.md` as the primary reference documents for implementing the game.
