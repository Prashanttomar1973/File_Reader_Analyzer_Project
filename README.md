# 📂 File Reader Analyzer (Java Swing Edition)

A comprehensive Java-based desktop application designed to read, analyze, and process text files efficiently. This project demonstrates advanced File I/O operations, keyword indexing, and word frequency analysis using a modular architecture.

## 🚀 Features
- **Interactive Swing UI**: A modern dashboard to manage file operations visually.
- **Efficient Reading**: Supports chunk-based reading (1024 bytes) for large files to prevent memory overflow.
- **Analytical Insights**: Calculates total line count, word count, and character count.
- **Keyword Search**: Locates specific keywords and returns their exact indices.
- **Word Frequency**: Uses `HashMap` to identify the most frequently used words.
- **Safe Resource Management**: Implements `Try-with-resources` for leak-proof stream handling.

## 🛠️ Tech Stack
- **Language**: Java
- **UI Framework**: Java Swing / AWT
- **Build Tool**: IntelliJ IDEA

## 📂 Project Structure
- `src/Main.java`: CLI Entry point.
- `src/SwingApp.java`: GUI Entry point.
- `src/File_Summary_Report/`: Core logic for file statistics.
- `src/ChunkBasedReading/`: Logic for handling large files.
- `src/Search_Analyze/`: Keyword indexing module.
