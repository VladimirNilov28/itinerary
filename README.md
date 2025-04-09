# ✈️ Prettifier — Route and Timestamp Formatter

A simple Java-based CLI tool that reads an input file with airport codes and timestamps, formats them into a human-readable form, and outputs the result to a new file using a provided airport lookup CSV.

---

## ⚙️ Compile the Project

Make sure you have `lombok.jar` placed in `src/main/resources`.

To compile all Java files into the `target/classes` directory:

```bash
javac -cp src/main/resources/lombok.jar -d target/classes $(find src/main/java -name "*.java")
```

---

## 🚀 Run the Program

### 🔹 Main Execution

```bash
java -cp target/classes org.example.prettifier.Prettifier input.txt output.txt airport-lookup.csv
```

- `input.txt` — path to the input file containing routes and airport codes.
- `output.txt` — path to save the formatted output.
- `airport-lookup.csv` — path to the airport lookup CSV file.

---

### ℹ️ Show Usage Instructions

```bash
java -cp target/classes org.example.prettifier.Prettifier -h
```

Displays correct usage instructions for the program.

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── org/example/prettifier/...
│   └── resources/
│       └── lombok.jar
target/
└── classes/        ← compiled output
```
