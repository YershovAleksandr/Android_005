package com.ssdd.myapplication;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import com.ssdd.myapplication.ActivityLoaderActivity;

public class TestBookmarks extends
		ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
	private Solo solo;

	public TestBookmarks() {
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

	// Executes TestBookmarks
	public void testRun() {
		
		int delay = 2000;
		
		// ================ Section One ===============
		// Wait for activity:
		// 'course.labs.permissionslab.ActivityLoaderActivity'
		assertTrue(
				"TestBookmarks:" +
				"Section One:" +
				"ActivityLoaderActivity did not load correctly.",
				solo.waitForActivity(com.ssdd.myapplication.ActivityLoaderActivity.class, delay));

		// Click on Bookmarks Activity
		solo.clickOnView(solo
				.getView(com.ssdd.myapplication.R.id.start_bookmarks_button));

		// Wait for activity: 'course.labs.permissionslab.BookmarksActivity'
		assertTrue(
				"TestBookmarks:" +
				"Section One:" +
				"BookmarksActivity did not load correctly.",
				solo.waitForActivity(com.ssdd.myapplication.BookmarksActivity.class, delay));
		
		// ================ Section Two ===============
		// Click on Get Bookmarks
		solo.clickOnView(solo
				.getView(com.ssdd.myapplication.R.id.get_bookmarks_button));

		// Check for at least one bookmark
		assertTrue("TestBookmarks:" +
				   "Section Two:" +
				   "Bookmarks are not correctly displayed.",
				solo.waitForText("http"));

		

	}
}
