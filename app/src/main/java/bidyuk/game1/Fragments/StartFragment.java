package bidyuk.game1.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bidyuk.game1.MainActivity;
import bidyuk.game1.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {
    public StartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.star_game_btn)
    public void StartBtnClick() {
        ((MainActivity)getActivity()).showGame();
    }

    @OnClick(R.id.exit_btn)
    public void ExitBtnClick() {
        getActivity().finish();
    }
}
