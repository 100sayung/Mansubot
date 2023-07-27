package com.discord.mansubot.webscraper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScraper {
    public static void helltidesTest() {
        // Use WebDriverManager to setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the webpage
            driver.get("https://helltides.com");


            // Find the span elements using a CSS selector
            WebElement firstSpan = driver.findElement(By.cssSelector(".text-4xl.whitespace-nowrap.lg\\:whitespace-normal.font-semibold.tracking-tight.text-white.text-center > div > div > span:first-child"));
            WebElement secondSpan = driver.findElement(By.cssSelector(".text-4xl.whitespace-nowrap.lg\\:whitespace-normal.font-semibold.tracking-tight.text-white.text-center > div > div > span:last-child"));

            // Extract the text values from the span elements
            String value1 = firstSpan.getText();
            String value2 = secondSpan.getText();

            // Print the extracted values
            System.out.println("Value 1: " + value1);
            System.out.println("Value 2: " + value2);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
