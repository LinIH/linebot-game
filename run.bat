@echo off
echo Changing directory to 'rpgame' to execute build...
pushd rpgame

echo.
echo ===================================
echo  Building RPG-Game Spring Boot App
echo ===================================
call mvnw.cmd clean package
if %errorlevel% neq 0 (
    echo.
    echo Maven build failed.
    popd
    exit /b %errorlevel%
)

echo.
echo ===================================
echo  Running RPG-Game Spring Boot App
echo ===================================
java -jar target/rpgame-0.0.1-SNAPSHOT.jar

echo.
echo Returning to original directory.
popd
