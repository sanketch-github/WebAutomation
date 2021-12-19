# WeatherShopper 

This is a java and selenium based sample project

File folder structure are as below image 

![image](https://user-images.githubusercontent.com/64305836/146672604-68df167e-3b24-4211-9caa-d091ea36e348.png)

Test Folder -> It Contains BestTest class and Test Case Class.

BaseTest: This is Base class of test class which have methods like before suite after suite and this class is extened in test classes
Test Case Folder: it has all test script created for test

![image](https://user-images.githubusercontent.com/64305836/146672667-0ff77d3c-b05f-4963-9f05-7f50d1242e61.png)

Test Data Folder -> It Contains Firefox and Chrome Driver

![image](https://user-images.githubusercontent.com/64305836/146672681-c6f896ab-b4f4-4bb8-b5e3-dac8c4d44650.png)

Test Result Folder-> It Contains the test result html file

![image](https://user-images.githubusercontent.com/64305836/146672710-acdd32ac-8977-4b99-8b4b-c81819647e61.png)

Ui-helper Folder -> It Contains Action Pages, Locator Pages and Base Page

Locator Pages: This folder contains all Locator Pages which is mainly created for storing locators.
Action Pages: This folder contains all action page class which mainly created for defining action in to methods and extends its locator page
Base Page: this class contain all common reusble methods eg Selenium Wait wrapper method 

![image](https://user-images.githubusercontent.com/64305836/146672745-bc5f713d-a645-41ea-9c0d-6737f356b54e.png)

Utility Folder -> It Contains Listner class, WebDriver manager class and Extent Report Class

![image](https://user-images.githubusercontent.com/64305836/146672783-6d974f07-603b-47b6-8c13-532bdfc08433.png)


For single Test Execution -> Go to the test -> java -> TestCase -> Select any test class -> Modify @Optional("browser type") to set browser type eg. Firefox and Chrome

![image](https://user-images.githubusercontent.com/64305836/146672852-30b4c045-8fda-43c2-a893-ced0cdaf900b.png)

For Parallel Test Execution -> Go to the test -> java -> Run Testing.xml file (you can do crossbrowser execution by changing browser value in file and u can set Thread count)

![image](https://user-images.githubusercontent.com/64305836/146672962-9dbed623-a75e-45eb-95eb-76167e0e609a.png)


If you face any issue please email me on sanketchaudhary1412@gmail.com 

