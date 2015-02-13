REM dataExtractor.bat

SET outputDB=D:\PROGRAMOWANIE\PROJECTS\kidney\data\db\

SET mongoDBLocalization="D:\wrk\mongodb\"

ECHO Starting MongoDB database...
CALL mongod -dbpath %outputDB%