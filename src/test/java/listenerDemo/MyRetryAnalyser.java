package listenerDemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyser implements IRetryAnalyzer{

	int minCount = 0;
	int maxCount = 3;
	@Override
	public boolean retry(ITestResult result) {
		
		while(minCount < maxCount)
		{
			minCount++;
			return true;
		}
		
		return false;
	}

}
