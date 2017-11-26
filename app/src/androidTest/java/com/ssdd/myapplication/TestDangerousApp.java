package com.ssdd.myapplication;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import com.ssdd.myapplication.ActivityLoaderActivity;


public class TestDangerousApp extends ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
  	private Solo solo;
  	
  	public TestDangerousApp() {
		super(ActivityLoaderActivity.class);
  	}

  	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
  	}
   	
   	// Executes TestDangerousApp
	public void testRun() {
				
		// ===================== Section One ===================
		// Wait for activity: 'course.labs.permissionslab.ActivityLoaderActivity'
		assertTrue("TestDangerousApp:" +
				"Section One:" +
				"ActivityLoaderActivity did not load correctly.", 
				solo.waitForActivity(com.ssdd.myapplication.ActivityLoaderActivity.class));

		// Click on Bookmarks Activity
		solo.clickOnView(solo.getView(com.ssdd.myapplication.R.id.start_bookmarks_button));

		// Wait for activity: 'course.labs.permissionslab.BookmarksActivity'
		assertTrue("TestDangerousApp:" +
				   "Section One:" +
				   "BookmarksActivity did not load correctly", 
				   solo.waitForActivity(com.ssdd.myapplication.BookmarksActivity.class));
		
		// ===================== Section Two ===================
		// Click on Go To DangerousActivity
		solo.clickOnView(solo.getView(com.ssdd.myapplication.R.id.go_to_dangerous_activity_button));

		// Wait for activity: 'course.labs.permissionslab.GoToDangerousActivity'
		assertTrue("TestDangerousApp:" +
				"Section Two:" +
				"GoToDangerousActivity did not load correctly", 
				solo.waitForActivity(com.ssdd.myapplication.GoToDangerousActivity.class));
		
		// Assert that: 'This button will load a Dangerous Level activity' is shown
		assertTrue("TestDangerousApp:" +
				"Section Two:" +
				"Dangerous Level activity button is not show.", 
				solo.waitForText(java.util.regex.Pattern.quote("This button will load a Dangerous Level activity")));
		
		// Click on Start Dangerous Activity
		solo.clickOnView(solo.getView(com.ssdd.myapplication.R.id.start_dangerous_activity_button));
		
	}
}
