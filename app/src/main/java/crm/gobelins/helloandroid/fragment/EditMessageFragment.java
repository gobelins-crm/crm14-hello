package crm.gobelins.helloandroid.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import crm.gobelins.helloandroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link crm.gobelins.helloandroid.fragment.EditMessageFragment.OnSendClickListener} interface
 * to handle interaction events.
 */
public class EditMessageFragment extends Fragment {

    private static final String TAG = "EDIT_MESSAGE_FRAGMENT";
    private OnSendClickListener mListener;
    private EditText mEditText;
    private Button mSendBtn;

    public EditMessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.edit_message, container, false);

        mEditText = (EditText) view.findViewById(R.id.edit_message);
        mSendBtn = (Button) view.findViewById(R.id.send_message);
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, mEditText.toString());

                mListener.onSendClick(mEditText.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSendClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnSendClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSendClickListener {
        public void onSendClick(String message);
    }

}
