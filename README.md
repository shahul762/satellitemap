# satellitemap



Selenium automation project for [https://satellitemap.space/](https://satellitemap.space/), simulating user interaction with the satellite globe, verifying orbit data, and capturing UI screenshots.

 Features
- Rotate the globe
- Zoom in until satellites appear
- Click a satellite dot and display orbit info
- Take screenshots and validate dynamic content

Tech Stack
- Java 22
- Selenium 4.33.0
- Maven
- ChromeDriver (compatible with Chrome 138+)
- TestNG (optional)
- Page Object Model (POM)




SatelliteAutomation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           └── HomePage.java
│   │       └── utils/
│   │           └── BaseTest.java
│   │       └── tests/
│   │           └── SatelliteTest.java
│
├── Screenshots/
│   └── *.png
│
├── pom.xml
├── README.md
└── .gitignore

