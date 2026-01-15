@echo off
@chcp 65001
cls

echo.
echo +--------------------------+
echo ^|  select your character   ^|
echo +--------------------------+
echo ^|  (1) game designer       ^|
echo ^|  (2) programmer          ^|
echo +--------------------------+
echo.
set /P OPTION=Select your character:
set RULES_FILE=rules/rules.txt

if %OPTION%==1 goto GAMER
if %OPTION%==2 goto PROGRAMMER

goto EOF

:GAMER
set ROLE_FILE=roles/role_gamer.txt
goto MAIN

:PROGRAMMER
set ROLE_FILE=roles/role_programmer.txt
goto MAIN


:MAIN
setlocal EnableDelayedExpansion

set RULES=
for /F "usebackq tokens=*" %%A in (%RULES_FILE%) do (
   set RULES=!RULES!%%A\n
)
set ROLE=
for /f "tokens=*" %%A in (%ROLE_FILE%) do (
   set ROLE=!ROLE!%%A\n
)

set INIT_INSTRU=%ROLE%%RULES%
rem echo %INIT_INSTRU%

gemini -i %INIT_INSTRU%

:EOF
exit /b