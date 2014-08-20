mvn install:install-file \
-DgroupId=com.felipecsl \
-DartifactId=abslistviewhelper \
-Dversion=$1 \
-DgeneratePom=true \
-Dpackaging=aar \
-Dfile=lib/build/outputs/aar/lib.aar \
-DlocalRepositoryPath=/Users/felipecsl/Data/Projects/m2repository/

mv /Users/felipecsl/Data/Projects/m2repository/com/felipecsl/abslistviewhelper/$1/maven-metadata-local.xml \
/Users/felipecsl/Data/Projects/m2repository/com/felipecsl/abslistviewhelper/$1/maven-metadata.xml

mv /Users/felipecsl/Data/Projects/m2repository/com/felipecsl/abslistviewhelper/maven-metadata-local.xml \
/Users/felipecsl/Data/Projects/m2repository/com/felipecsl/abslistviewhelper/maven-metadata.xml