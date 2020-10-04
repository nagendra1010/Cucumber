package ReusableFunctions;
import java.util.ArrayList;

import cucumber.api.Scenario;

public class StaticVariable {
	public static String Application="Shopping portal";
	public static String BROWSER=null;
	public static String SCREENSHOTS=null;
	public static String chromeDriverpath=null;
	public static String OBJECTREPOSITORY=null;
	public static String CaseHandlingSystem_URL=null;
	public static int EXCELLASTROWNUM=0;	
	public static String MAX_WAIT_TIME="";
	public static String TESTDATAREPO=null;
	public static String SCENARIO_NAME=null;
	public static String HIGHLIGHTS=null;
	public static String CURRENTUSERSHOMEDIR=System.getProperty("user.dir");
	public static String LOCALPATH=null;
	public static ArrayList<String> BROWSERTABS = null;
	public static String PASS="Pass";
	public static String FAIL="Fail";
	public static String SHAREDRESULTS=null;
	public static String SHAREDPATH=null;
	
	public static final String RESULTPATH="//psrvwapp0386//RTA Backups//GIT//Automation//report.html";
	public static Scenario message = null;
}
