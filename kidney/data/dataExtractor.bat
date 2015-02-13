REM dataExtractor.bat

SET outputDB="D:\PROGRAMOWANIE\PROJECTS\kidney\data\db\"
SET inputFile="kidney_to_export.csv"
SET mongoDBLocalization="D:\wrk\mongodb\"

ECHO Creating MongoDB database...
CALL mongoimport.exe -v -d %outputDB% -c kidey.db --type csv --file %inputFile% --headerline
ECHO MongoDB database created.