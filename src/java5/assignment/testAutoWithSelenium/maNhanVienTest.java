package java5.assignment.testAutoWithSelenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional.TxType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class maNhanVienTest {
	public static WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingdir;
	public static String url = "http://localhost:8080/DemoTestJ5/user/login.htm";
	public static final String webdriver = "webdriver.chrome.driver";
	public static final String pathDriver = "C:\\Users\\quant\\OneDrive\\Desktop\\Junit4\\chromedriver.exe";
	
	@BeforeMethod
	public void setUp() {
		String url = "http://localhost:8080/DemoTestJ5/staff/insertStaff.htm";
		driver.get(url);
	}

	@AfterMethod
	public void tearDow() {
//		driver.close();
	}

	@BeforeTest
	public void beforeTest()throws Exception {
		try {
			workingdir = System.getProperty("user.dir");
			System.out.println(workingdir);
			datafile = new UIMap(workingdir+"\\Resources\\datafile.properties");
			uimap = new UIMap(workingdir+"\\Resources\\locator.properties");
			System.setProperty(webdriver, pathDriver);
			driver = new ChromeDriver();
			driver.get(url);
			WebElement txtUsername = driver.findElement(uimap.getLocator("txtUsername"));
			txtUsername.sendKeys("quanth");
			
			WebElement txtPassword = driver.findElement(uimap.getLocator("txtPassword"));
			txtPassword.sendKeys("quanta");
			WebElement buttonLogin = driver.findElement(uimap.getLocator("btnLogin"));
			Thread.sleep(1000);
			buttonLogin.click();
			
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@AfterTest
	public void afterTest() {
//		driver.close();
	}

//	@Test(description = "kh??ng nh???p m?? nh??n vi??n", priority = 1)
//	public void insertStaff1() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys("");
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
////			WebElement buttonUp = driver.findElement(By.id("file-upload-button"));
////			buttonUp.click();
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(By.id("id.errors"));
//			String actual = error.getText();
//			
//			String expected = "M?? nh??n vi??n kh??ng ch???a k?? t??? ?????c bi???t\r\n" + 
//					"Kh??ng ????? tr???ng m?? nh??n vi??n!\n" + 
//					"M?? nh??n vi??n c?? ????? d??i t???i ??a l?? 10 k?? t???!\r\n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Ma nhan vien gom 1 ki tu", priority = 2)
//	public void insertStaff2() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv1"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(By.id("id.errors"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "Ma nhan vien gom 9 ki tu", priority = 3)
//	public void insertStaff3() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv9"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(By.id("id.errors"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "Ma nhan vien gom 10 ki tu", priority = 4)
//	public void insertStaff4() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv10"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(By.id("id.errors"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "Ma nhan vien gom 11 ki tu", priority = 5)
//	public void insertStaff5() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv11"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(By.id("id.errors"));
//			String actual = error.getText();
//			
//			String expected = "M?? nh??n vi??n c?? ????? d??i t???i ??a l?? 10 k?? t???!";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Ma nhan vien chi chua ki tu khoang trang", priority = 6)
//	public void insertStaff6() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys("    ");
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(By.id("id.errors"));
//			String actual = error.getText();
//			
//			String expected = "M?? nh??n vi??n kh??ng ch???a k?? t??? ?????c bi???t\r\n" + 
//					"Kh??ng ????? tr???ng m?? nh??n vi??n!\n" + 
//					"M?? nh??n vi??n c?? ????? d??i t???i ??a l?? 10 k?? t???!\r\n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	

//	@Test(description = "Email khong hop le", priority = 7)
//	public void insertStaff7() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("emailfalse"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("emailError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????ng ?????nh d???ng email";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Th??m nh??n vi??n v???i email b??? b??? tr???ng", priority = 8)
//	public void insertStaff8() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys("    ");
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("emailError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng email!";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
////	@Test(description = "Th??m nh??n vi??n v???i email ????ng ?????nh d???ng", priority = 9)
////	public void insertStaff9() {
////		try {
////			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
////			txtId.sendKeys(datafile.getData("manv"));
////			
////			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
////			Thread.sleep(1000);
////			txtName.sendKeys(datafile.getData("tennv"));
////			
////			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
////			txtBirthday.sendKeys(datafile.getData("birthday"));
////			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
//////			Thread.sleep(2000);
////			uploadFile.sendKeys(datafile.getData("anh"));
////			Thread.sleep(2000);
////			
////			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
////			txtEmail.sendKeys(datafile.getData("email"));
////			
////			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
////			txtPhone.sendKeys(datafile.getData("phone"));
////			
////			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
////			btnSubmit.click();
//////			Thread.sleep(2000);
////			WebElement error = driver.findElement(By.id("email.errors"));
////			String actual = error.getText();
////			
////			String expected = "Kh??ng ????ng ?????nh d???ng email";
////			
////			assertEquals(actual, expected);
////			
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
////	}
//	
//	@Test(description = "Th??m nh??n vi??n v???i s??? ??i???n c?? ????? d??i 10 ch??? s??? v???i s??? ?????u ti??n kh??ng b???t ?????u b???ng s??? 0", priority = 10)
//	public void insertStaff10() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phonenot010"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("phoneError"));
//			String actual = error.getText();
//			
//			String expected = "S??? ??i???n tho???i ph???i l?? s??? c?? 10 ch??? s??? v?? b???t ?????u b???ng 0";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "s??? ??i???n c?? ????? d??i 10 ch??? s??? v???i s??? ?????u ti??n b???t ?????u b???ng s??? 0", priority = 11)
//	public void insertStaff11() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("phoneError"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "s??? ??i???n c?? ????? d??i 9 ch??? s??? v???i s??? ?????u ti??n b???t ?????u b???ng s??? 0", priority = 12)
//	public void insertStaff12() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone9"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("phoneError"));
//			String actual = error.getText();
//			
//			String expected = "S??? ??i???n tho???i ph???i l?? s??? c?? 10 ch??? s??? v?? b???t ?????u b???ng 0";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "s??? ??i???n c?? ????? d??i 11 ch??? s??? v???i s??? ?????u ti??n b???t ?????u b???ng s??? 0", priority = 13)
//	public void insertStaff13() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone11"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("phoneError"));
//			String actual = error.getText();
//			
//			String expected = "S??? ??i???n tho???i ph???i l?? s??? c?? 10 ch??? s??? v?? b???t ?????u b???ng 0";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "s??? ??i???n l?? ch???", priority = 14)
//	public void insertStaff14() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phonestring"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("phoneError"));
//			String actual = error.getText();
//			
//			String expected = "S??? ??i???n tho???i ph???i l?? s??? c?? 10 ch??? s??? v?? b???t ?????u b???ng 0";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "s??? ??i???n ch??? g???m k?? t??? kho???ng tr???ng", priority = 15)
//	public void insertStaff15() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phonestring"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("phoneError"));
//			String actual = error.getText();
//			
//			String expected = "S??? ??i???n tho???i ph???i l?? s??? c?? 10 ch??? s??? v?? b???t ?????u b???ng 0\r\n" + 
//					"Kh??ng ????? tr???ng s??? ??i???n tho???i!";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "Kh??ng nh???p t??n nh??n vi??n", priority = 16)
//	public void insertStaff16() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys("");
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng t??n nh??n vi??n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "Nh???p t??n nh??n vi??n v???i k?? t??? ?????c bi???t", priority = 17)
//	public void insertStaff17() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennvdb"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng t??n nh??n vi??n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Nh???p t??n nh??n vi??n ch???a s???", priority = 18)
//	public void insertStaff18() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennso"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng t??n nh??n vi??n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Nh???p t??n nh??n vi??n ch??? ch???a kho???ng tr???ng", priority = 19)
//	public void insertStaff19() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys("         ");
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng t??n nh??n vi??n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Test(description = "Nh???p t??n nh??n vi??n g???m 1 k?? t???", priority = 20)
//	public void insertStaff20() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv1"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Nh???p t??n nh??n vi??n g???m 2 k?? t???", priority = 21)
//	public void insertStaff21() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv2"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Nh???p t??n nh??n vi??n g???m 49 k?? t???", priority = 22)
//	public void insertStaff22() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv49"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	
//	@Test(description = "Nh???p t??n nh??n vi??n g???m 50 k?? t???", priority = 23)
//	public void insertStaff23() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv50"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
//	@Test(description = "Nh???p t??n nh??n vi??n g???m 51 k?? t???", priority = 24)
//	public void insertStaff24() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv51"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
////			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("nameError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng t??n nh??n vi??n";
//			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
//	@Test(description = "Nh???p l????ng l?? ch???", priority = 25)
//	public void insertStaff25() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement txtSalary = driver.findElement(uimap.getLocator("txtSalary"));
//			txtSalary.clear();
//			txtSalary.sendKeys(datafile.getData("salarystring"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "Failed to convert property value of type java.lang.String to required type java.lang.Float for property salary; nested exception is java.lang.NumberFormatException: For input string: \"aaaaaaaaaaa\"";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Nh???p l????ng nh??? h??n 0", priority = 26)
//	public void insertStaff26() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement txtSalary = driver.findElement(uimap.getLocator("txtSalary"));
//			txtSalary.clear();
//			txtSalary.sendKeys(datafile.getData("salaryam"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "L????ng ph???i l???n h??n 0!";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Nh???p l????ng b???ng 0", priority = 27)
//	public void insertStaff27() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement txtSalary = driver.findElement(uimap.getLocator("txtSalary"));
//			txtSalary.clear();
//			txtSalary.sendKeys("0");
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "L????ng ph???i l???n h??n 0!";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Nh???p l????ng l???n h??n 0", priority = 28)
//	public void insertStaff28() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement txtSalary = driver.findElement(uimap.getLocator("txtSalary"));
//			txtSalary.clear();
//			txtSalary.sendKeys(datafile.getData("salary"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Nh???p l????ng l???n h??n 0", priority = 29)
//	public void insertStaff29() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement txtSalary = driver.findElement(uimap.getLocator("txtSalary"));
//			txtSalary.clear();
//			txtSalary.sendKeys("       ");
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "Kh??ng ????? tr???ng l????ng!";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Nh???p l????ng g???m c??? ch??? v?? s???", priority = 30)
//	public void insertStaff30() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			WebElement txtSalary = driver.findElement(uimap.getLocator("txtSalary"));
//			txtSalary.clear();
//			txtSalary.sendKeys(datafile.getData("salarystringnumber"));
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "Failed to convert property value of type java.lang.String to required type java.lang.Float for property salary; nested exception is java.lang.NumberFormatException: For input string: \"a234a23sa\"";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
//	
//	@Test(description = "Nh???p l????ng g???m c??? ch??? v?? s???", priority = 31)
//	public void insertStaff31() {
//		try {
//			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
//			txtId.sendKeys(datafile.getData("manv"));
//			
//			WebElement txtName =driver.findElement(uimap.getLocator("txtName"));
//			Thread.sleep(1000);
//			txtName.sendKeys(datafile.getData("tennv"));
//			
//			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
//			txtBirthday.sendKeys(datafile.getData("birthday"));
//			WebElement uploadFile = driver.findElement(uimap.getLocator("txtPhoto"));
////			Thread.sleep(2000);
//			uploadFile.sendKeys(datafile.getData("anh"));
//			Thread.sleep(2000);
//			
//			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
//			txtEmail.sendKeys(datafile.getData("email"));
//			
//			WebElement txtPhone = driver.findElement(uimap.getLocator("txtPhone"));
//			txtPhone.sendKeys(datafile.getData("phone"));
//			
//			
//			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
//			btnSubmit.click();
//			Thread.sleep(2000);
//			WebElement error = driver.findElement(uimap.getLocator("salaryError"));
//			String actual = error.getText();
//			
//			String expected = "";
////			
//			assertEquals(actual, expected);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
	
	@Test(description = "B??? tr???ng t???t c??? c??c tr?????ng", priority = 32)
	public void insertStaff32() {
		try {
			long id = Thread.currentThread().getId();
			System.out.println(id);
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	@Test(description = "B??? tr???ng  h??? t??n, ng??y sinh, ???nh, email, sdt, m?? ph??ng ban", priority = 33)
	public void insertStaff33() {
		try {
			long id = Thread.currentThread().getId();
			System.out.println(id);
			WebElement txtId = driver.findElement(uimap.getLocator("txtId"));
			txtId.sendKeys(datafile.getData("manv"));
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	@Test(description = "B??? tr???ng M?? nh??n vi??n, ng??y sinh, ???nh, email, sdt, m?? ph??ng ban", priority = 34)
	public void insertStaff34() {
		try {
			long id = Thread.currentThread().getId();
			System.out.println(id);
			WebElement txtName = driver.findElement(uimap.getLocator("txtName"));
			txtName.sendKeys(datafile.getData("tennv"));
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	@Test(description = "B??? tr???ng M?? nh??n vi??n, h??? t??n, ???nh, email, sdt, m?? ph??ng ban", priority = 35)
	public void insertStaff35() {
		try {
			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtBirthday"));
			txtBirthday.sendKeys(datafile.getData("birthday"));
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			long id = Thread.currentThread().getId();
			System.out.println(id);
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	@Test(description = "B??? tr???ng M?? nh??n vi??n, h??? t??n, ng??y sinh, email, sdt, m?? ph??ng ban", priority = 36)
	public void insertStaff36() {
		try {
			WebElement txtPhoto = driver.findElement(uimap.getLocator("txtPhoto"));
			txtPhoto.sendKeys(datafile.getData("anh"));
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			long id = Thread.currentThread().getId();
			System.out.println(id);
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	@Test(description = "B??? tr???ng M?? nh??n vi??n, h??? t??n, ng??y sinh, ???nh, sdt, m?? ph??ng ban", priority = 37)
	public void insertStaff37() {
		try {
			WebElement txtEmail = driver.findElement(uimap.getLocator("txtEmail"));
			txtEmail.sendKeys(datafile.getData("email"));
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			long id = Thread.currentThread().getId();
			System.out.println(id);
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	@Test(description = "B??? tr???ng M?? nh??n vi??n, h??? t??n, ng??y sinh, ???nh, email, m?? ph??ng ban", priority = 38)
	public void insertStaff38() {
		try {
			WebElement txtBirthday = driver.findElement(uimap.getLocator("txtPhone"));
			txtBirthday.sendKeys(datafile.getData("phone"));
			WebElement btnSubmit = driver.findElement(uimap.getLocator("btnSubmit"));
			btnSubmit.click();
			Thread.sleep(2000);
			WebElement error = driver.findElement(uimap.getLocator("error"));
			String actual = error.getText();
			long id = Thread.currentThread().getId();
			System.out.println(id);
			
			String expected = "Ho??n th??nh ?????y ????? nh???ng th??ng tin d?????i ????y";
//			
			assertEquals(actual, expected);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
}
