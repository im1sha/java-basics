
mkdir compiledTask

mkdir compiledTask\bin

javac -sourcepath .\src -d .\compiledTask\bin .\src\by\bsuir\ovchelupov\task09\runner\Runner.java

java -classpath .\compiledTask\bin by.bsuir.ovchelupov.task09.runner.Runner
