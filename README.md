# MobileApp-Automation-Appium
This project has been developed to automate mobile application on Android and iOS platform using Java, Appium, TestNG and Maven.

## Steps to run the application:

1. Install Appium Server (CLI). Follow instructions on [Appium Installation Help](http://appium.io/docs/en/about-appium/getting-started/). Appium Server need not be started externally, it is handled in the code itself.

2. Install Android SDK (Command line tools). Follow instructions on [Android Installation Help](https://developer.android.com/studio/?gclid=CjwKCAjwwYP2BRBGEiwAkoBpAohuHRSwpwUk11WkmX7U1dBifIror9wPrmD_xfqMJVCdfkNqB-nSbhoCFyMQAvD_BwE&gclsrc=aw.ds)

3. Connect your android device and verify connectivity.

4. Update testng.xml with android device details (Device Name, UDID and Platform version).

5. Run the below command on Command Prompt.

```sh
mvn clean install
```



## App Design

1. Android Testcases can be found here -> https://github.com/Pooja-shettigar/MobileApp-Automation-Appium/tree/master/src/test/java/testScripts/Android 
2. iOS Testcases can be found here -> https://github.com/Pooja-shettigar/MobileApp-Automation-Appium/tree/master/src/test/java/testScripts/iOS 
3. Code for application framework can be found here -> https://github.com/Pooja-shettigar/MobileApp-Automation-Appium/tree/master/src/main/java
4. Test data is read from external source file ->  https://github.com/Pooja-shettigar/MobileApp-Automation-Appium/tree/master/src/test/resources
5. Android and iOS Congif details can be found here -> https://github.com/Pooja-shettigar/MobileApp-Automation-Appium/blob/master/config.yaml 
6. Extent Reports is used for reporting functionality.
7. On completion of execution, test report will be generated here -> https://github.com/Pooja-shettigar/MobileApp-Automation-Appium/tree/master/test-output 



