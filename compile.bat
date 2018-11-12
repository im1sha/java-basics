
mkdir task9compiled

mkdir task9compiled\bin

javac -sourcepath .\src -d .\task9compiled\bin .\src\by\bsuir\ovchelupov\task09\Runner.java

java -classpath .\task9compiled\bin by.bsuir.ovchelupov.task09.runner.Runner