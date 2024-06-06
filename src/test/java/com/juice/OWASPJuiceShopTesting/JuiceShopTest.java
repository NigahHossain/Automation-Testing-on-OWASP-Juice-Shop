package com.juice.OWASPJuiceShopTesting;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class JuiceShopTest extends BaseDriver {
	
	@Test
	public void browseWebsite() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.get("https://juice-shop.herokuapp.com/#/login");
		Thread.sleep(3000);
		
		 // Close the welcome banner if it appears
        try {
            WebElement closeBanner = driver.findElement(By.cssSelector(".close-dialog"));
            if (closeBanner.isDisplayed()) {
                closeBanner.click();
            }
        } catch (Exception e) {
            // Ignore if the banner is not present
        }
		
		System.out.println(driver.getTitle());
		
		// Login
		
		WebElement email = driver.findElement(By.id("email"));
 		email.sendKeys("nigah.hossain@gmail.com");
		Thread.sleep(1000);
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345@");
		Thread.sleep(1000);
		
		
		WebElement login = driver.findElement(By.id("loginButton"));
 		login.click();
		Thread.sleep(1000);
       
		
		// Add 1 item to the basket
		WebElement addItemButton = driver.findElement(By.cssSelector("button[aria-label='Add to Basket']"));
        addItemButton.click();
        Thread.sleep(1000);
        
        
        WebElement BasketButton = driver.findElement(By.cssSelector("button[aria-label='Show the shopping cart']"));
        BasketButton.click();
        Thread.sleep(3000);
        
        // Proceed to checkout
        WebElement checkout = driver.findElement(By.id("checkoutButton"));
        checkout.click();
        Thread.sleep(3000);
        
        
        // Add a new address
        WebElement AddNewAddress = driver.findElement(By.cssSelector("button[aria-label='Add a new address']"));
        AddNewAddress.click();
        Thread.sleep(1000);
        
        WebElement country = driver.findElement(By.xpath("//input[@placeholder='Please provide a country.']"));
 		country.sendKeys("Bangladesh");
		Thread.sleep(1000);
		
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Please provide a name.']"));
        name.sendKeys("Nigah Hossain");
        Thread.sleep(1000);

        WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Please provide a mobile number.']"));
        mobile.sendKeys("1234567890");
        Thread.sleep(1000);

        WebElement zipCode = driver.findElement(By.xpath("//input[@placeholder='Please provide a ZIP code.']"));
        zipCode.sendKeys("12345");
        Thread.sleep(1000);

        WebElement address = driver.findElement(By.xpath("//textarea[@placeholder='Please provide an address.']"));
        address.sendKeys("Mirpur");
        Thread.sleep(1000);

        WebElement city = driver.findElement(By.xpath("//input[@placeholder='Please provide a city.']"));
        city.sendKeys("Dhaka");
        Thread.sleep(1000);

        WebElement state = driver.findElement(By.xpath("//input[@placeholder='Please provide a state.']"));
        state.sendKeys("Dhaka");
        Thread.sleep(3000);

		
		
		WebElement submit = driver.findElement(By.id("submitButton"));
 		submit.click();
		Thread.sleep(5000);
        
//		driver.findElement(By.id("navbarAccount")).click();
//        driver.findElement(By.id("navbarLoginButton")).click();

    }
	
	
	@Test
    public void verifySearchFunctionality() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://juice-shop.herokuapp.com/#/search");
        Thread.sleep(3000);
        
        // Close the welcome banner if it appears
        try {
            WebElement closeBanner = driver.findElement(By.cssSelector(".close-dialog"));
            if (closeBanner.isDisplayed()) {
                closeBanner.click();
            }
        } catch (Exception e) {
            // Ignore if the banner is not present
        }

        // Search for "apple"
        WebElement searchIcon = driver.findElement(By.cssSelector("mat-search-bar[aria-label='Click to search']"));
        searchIcon.click();
        Thread.sleep(1000);
        

        WebElement searchField = driver.findElement(By.cssSelector("input.mat-input-element"));
        searchField.sendKeys("apple");
        Thread.sleep(1000);


        // Press enter to initiate the search
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        
   

        // Verify two apple products are shown and no banana product is shown
        int appleProductsCount = driver.findElements(By.xpath("//mat-card[contains(., 'Apple')]")).size();
        Assert.assertEquals(appleProductsCount, 2, "There should be 2 apple products displayed.");
        
        int bananaProductsCount = driver.findElements(By.xpath("//mat-card[contains(., 'Banana')]")).size();
        Assert.assertEquals(bananaProductsCount, 0, "There should be no banana products displayed.");
        
        Thread.sleep(5000);  // Added to see the results in the browser
    }
	
	
}

