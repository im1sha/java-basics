cd .\task9compiled
echo main-class: by.bsuir.ovchelupov.task09.runner.Runner>manifest.mf
jar -cmf manifest.mf task09.jar -C bin .
java -jar task09.jar