@echo 
goto install


:exit
exit

:clean
gradlew clean
pause

:install
gradlew install
pause