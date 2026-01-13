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
set /P OPTION=Option:
set RULES_FILE=rules/rules.txt

IF %OPTION%==1 (
   set SYSTEM_FILE=system/system_gamer.txt
) ELSE IF %OPTION%==2 (
   set SYSTEM_FILE=system/system_programmer.txt
) ELSE (
   goto EOF
)

setlocal EnableDelayedExpansion

set RULES=
for /F "usebackq tokens=*" %%A in (%RULES_FILE%) do (
   set RULES=!RULES!%%A\n
)
set SYSTEM=
for /f "tokens=*" %%A in (%SYSTEM_FILE%) do (
   set SYSTEM=!SYSTEM!%%A\n
)

set INIT_INSTRU=%SYSTEM%%RULES%

gemini -i %INIT_INSTRU%

:EOF
exit /b