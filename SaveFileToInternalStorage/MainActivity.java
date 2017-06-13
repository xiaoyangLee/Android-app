package com.lxy.teststorage;

import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button_save = (Button) findViewById(R.id.button_save);

		button_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SaveFile();
			}

		});
	}

	/**
	 * SavaFile()用于保存文件信息
	 */
	private void SaveFile() {
		// TODO Auto-generated method stub
		String fileInfo = "I am the text to introduce how to use this app.";
		FileOutputStream fos = null;
		try {
			fos = openFileOutput("data.txt", MODE_PRIVATE);
			fos.write(fileInfo.getBytes());
			fos.flush();

			// getFilesDir()
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
					Toast.makeText(this, "Save successfully!", Toast.LENGTH_SHORT).show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
