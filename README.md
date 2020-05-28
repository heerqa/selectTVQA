# heer-FreeCast

### Run tests

* Clone the repository
* Go inside the folder and run following command from terminal/command prompt
* To run tests on Chrome
```
   mvn clean verify serenity:aggregate -Dwebdriver.driver=chrome -Pserenity 
```

* To run tests on Firefox 
```
   mvn clean verify serenity:aggregate -Dwebdriver.driver=firefox -Pserenity 
```

### HTML Reports

Html report is generated in the 'target\site\serenity' folder.