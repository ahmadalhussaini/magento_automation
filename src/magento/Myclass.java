package magento;

import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Myclass extends Propertes {
	@BeforeTest
	public void my_setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://magento.softwaretestingboard.com/");
	}

@Test
public void signup() {
	driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Ahmad");
	driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("taher");
	driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("ahmadalhussaini44@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ahmad&2000");
	driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("Ahmad&2000");
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
}

//	@Test(priority = 1)
//	public void login() throws InterruptedException {
//		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
//		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ahmadalhussaini@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Ahmad&2000");
//		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
//		Thread.sleep(3000);
//
//	}

@Test(priority = 2)
public void  search_randomly() {
	
	
	String[] collection= { "Jacket","t-shirt","jeans for men","jeans for women","pants"};
	Random rand=new Random();
   int randomindex=	rand.nextInt(5);
   driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys(collection[randomindex]);
   String item_selected=  driver.findElement(By.xpath("//*[@id=\"search\"]")).getAttribute("value");
   System.out.println(item_selected);
   }

	@Test(priority = 3)
	public void add_items_to_cart() throws InterruptedException {

		String[] hrefs = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };
		int counter = 1;

		for (int i = 0; i < hrefs.length; i++) {
			if (i == 0) {
				driver.get(hrefs[i]);
				counter = 3;
			} else if (i == 1) {
				driver.get(hrefs[i]);
				counter = 2;

			} else if (i == 2) {
				driver.get(hrefs[i]);
				counter = 4;

			} else if (i == 3) {
				driver.get(hrefs[i]);
				counter = 1;

			}
			// the item is empty
//	else if(i==4) {
//		driver.get(hrefs[i]);
//		 for(int j=0;j<5;j++) {
//			    driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();	
//				break;
//		 }
//		 }
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			List<WebElement> size = driver.findElements(By.xpath("//div[@class='swatch-option text']"));
			List<WebElement> color = driver.findElements(By.xpath("//div[@class='swatch-option color']"));
			Thread.sleep(2000);
			Random rand = new Random();
			for (int j = 0; j < counter; j++) {

				int randomsize = rand.nextInt(size.size());
				int randomcolor = rand.nextInt(color.size());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

				size.get(randomsize).click();
				Thread.sleep(4000);

				color.get(randomcolor).click();
				Thread.sleep(4000);

				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(4000);
				// to reset size and color
				size.get(randomsize).click();
				Thread.sleep(4000);

				color.get(randomcolor).click();
				driver.findElement(By.xpath("//*[@id=\"option-label-size-143\"]")).click();
				Thread.sleep(5000);
			}

		}

	}

	@Test(priority = 4)
	public void Shipping_Address() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/checkout/#shipping");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("company")).sendKeys("alhussaini company");

		driver.findElement(By.name("street[0]")).sendKeys("jordan");
		driver.findElement(By.name("street[1]")).sendKeys("zarqa");
		driver.findElement(By.name("street[2]")).sendKeys("st.alhai alshammalie");
		driver.findElement(By.name("city")).sendKeys("zarqa");
		driver.findElement(By.name("postcode")).sendKeys("010001");
		driver.findElement(By.name("country_id")).sendKeys("Jordan");
		driver.findElement(By.name("telephone")).sendKeys("00962780122428");
		Thread.sleep(4000);
		driver.findElement(By.name("region")).sendKeys("zarqa");
		driver.findElement(By.xpath("//*[@id=\"opc-shipping_method\"]/div/div[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
	}
	@Test(priority = 5)
	public void Assertion_price() throws InterruptedException {
//		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
//		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("ahmadalhussaini@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Ahmad&2000");
//		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
//		Thread.sleep(3000);
//	driver.get("https://magento.softwaretestingboard.com/checkout/#shipping");
//	Thread.sleep(15000);
//	driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a")).click();
   String price=driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[3]/td/strong/span")).getText();
   String accualprice="$54.00";
   myAssertion.assertEquals(accualprice, price);
   myAssertion.assertAll();
		
	}
	
	@Test( priority = 6,invocationCount=5)
	public void Re_order() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a")).click();
		

	
}
	@Test( priority = 7)
	public void check_price() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(5000);
		String price_order="$319.00";
	String order_one=	driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[4]/span")).getText();
	String order_tow=	driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[2]/td[4]/span")).getText();
	String order_three=	driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[3]/td[4]/span")).getText();
	String order_four=	driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[4]/td[4]/span")).getText();
	String order_five=	driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[5]/td[4]/span")).getText();
	   myAssertion.assertEquals(price_order, order_one);
	   myAssertion.assertEquals(order_one,order_tow);
	   myAssertion.assertEquals(order_tow,order_three);
	   myAssertion.assertEquals(order_three, order_four);
	   myAssertion.assertEquals( order_four, order_five);
	   System.out.println("all order is same price");
	   myAssertion.assertAll();
	}
	
	
	
	
	
	
	
}
