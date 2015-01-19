package crm.gobelins.helloandroid.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DisplayMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DisplayMessageFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_MESSAGE = "arg_message";

    private String mMessage;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param message Parameter 1.
     * @return A new instance of fragment DisplayMessageFragment.
     */
    public static DisplayMessageFragment newInstance(String message) {
        DisplayMessageFragment fragment = new DisplayMessageFragment();

        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);

        return fragment;
    }

    public DisplayMessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mMessage = getArguments().getString(ARG_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());

        textView.setText(mMessage);

        return textView;
    }


}
