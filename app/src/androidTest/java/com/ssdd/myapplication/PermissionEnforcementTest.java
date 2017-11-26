package com.ssdd.myapplication;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import com.ssdd.myapplication.ActivityLoaderActivity;

public class PermissionEnforcementTest extends
		ActivityInstrumentationTestCase2<ActivityLoaderActivity> {
	private Solo solo;

	public PermissionEnforcementTest() {
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

	// Executes PermissionEnforcementTest
	public void testRun() {
		
		// =============== Section One ==================
		solo.waitForActivity(
				com.ssdd.myapplication.ActivityLoaderActivity.class, 2000);

		PackageManager pm = getActivity().getPackageManager();
		try {
			ActivityInfo activityInfo = pm.getActivityInfo(new ComponentName(
					"com.ssdd.myapplication42",
					"com.ssdd.myapplication42.DangerousActivity"), 0);
			assertTrue(
					"PermissionEnforcementTest:" +
					"Section One:" +
					"com.ssdd.myapplication.DANGEROUS_ACTIVITY_PERM not enforced by DangerousActivity",
					null != activityInfo && null != activityInfo.permission
							&& activityInfo.permission
									.equals("com.ssdd.myapplication42.DANGEROUS_ACTIVITY_PERM"));
		} catch (NameNotFoundException e) {
			fail("PermissionEnforcementTest:" +
					"Section One:" +
					"DangerousActivity not found");
		}
	}
}
