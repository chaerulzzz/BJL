package luhut.belajar.jepang.com.belajarjepang.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import luhut.belajar.jepang.com.belajarjepang.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private TextInputEditText mUserName, mPassword;
    private TextInputLayout mUserLayout, mPasswordLayout;
    private AppCompatButton mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.init();
    }

    private void init() {
        mContext = getApplicationContext();
        mUserLayout = findViewById(R.id.login_user_layout);
        mPasswordLayout = findViewById(R.id.login_password_layout);

        mUserName = findViewById(R.id.login_user);

        mPassword = findViewById(R.id.login_password);
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    mPassword.setError(null);
                    mPasswordLayout.setPasswordVisibilityToggleEnabled(true);
                    mPasswordLayout.setPasswordVisibilityToggleTintList(ContextCompat.getColorStateList(mContext, android.R.color.black));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (mLoginButton.equals(view)) {
            if (TextUtils.isEmpty(mUserName.getText().toString())) {
                mUserName.setError(null);
                mUserLayout.setErrorEnabled(true);
                mUserLayout.setError("Username tidak boleh kosong");
            }

            if (TextUtils.isEmpty(mPassword.getText().toString())) {
                mPassword.setError(null);
                mPasswordLayout.setErrorEnabled(true);
                mPasswordLayout.setError("Password tidak boleh kosong");
            }

            String mUser = mUserName.getText().toString();
            String pass = mPassword.getText().toString();

            if (mUser.equalsIgnoreCase("admin")) {
                if(pass.equalsIgnoreCase("sma73")) {
                    Toast.makeText(mContext, "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    mPassword.setError(null);
                    mPasswordLayout.setErrorEnabled(true);
                    mPasswordLayout.setError("Password salah");
                }
            } else {
                mUserName.setError(null);
                mUserLayout.setErrorEnabled(true);
                mUserLayout.setError("Username salah");
            }
        }
    }
}
