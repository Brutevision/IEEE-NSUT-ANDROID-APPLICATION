package com.dev.ieeensut.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.ieeensut.R;

/**
 */
public class IeeeFragment extends Fragment {

    public IeeeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ieee, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView overviewTextView = (TextView) view.findViewById(R.id.overviewTextView);
        TextView missionTextView = (TextView) view.findViewById(R.id.missionTextView);
        TextView visionTextView = (TextView) view.findViewById(R.id.visionTextView);
        TextView activitiesTextView = (TextView) view.findViewById(R.id.activitiesTextView);
        TextView scholarshipTextView = (TextView) view.findViewById(R.id.scholarshipTextView);

        overviewTextView.setText(Html.fromHtml("<h4>Overview</h4>\n"
                                                        + "IEEE is the world’s largest technical professional organization dedicated to advancing technology for the benefit of humanity. Below, you can find IEEE's mission and vision statements."));
        missionTextView.setText(Html.fromHtml("<h4>Mission statement</h4>\n"
                                                        + "IEEE's core purpose is to foster technological innovation and excellence for the benefit of humanity."));
        visionTextView.setText(Html.fromHtml("<h4>Vision statement</h4>\n"
                                                        + "IEEE will be essential to the global technical community and to technical professionals everywhere, and be universally recognized for the contributions of technology and of technical professionals in improving global conditions."));
        activitiesTextView.setText(Html.fromHtml("<h4>Student Activities</h4>\n"
                                                        + "IEEE offers many student awards, competitions, and other opportunities to get actively involved.\n"
                                                        + "<ul><li>Competitions</li><li>IEEEXtreme Programming Competition</li><li>IEEEmadC</li><li>Student Branch Awards</li><li>Scholarships, Grants, and Fellowships</li></ul>"));
        scholarshipTextView.setText(Html.fromHtml("<h4>Scholarships</h4>\n"
                                                        + "IEEE Life Members Graduate Study Fellowship in Electrical Engineering was established by the IEEE in 2000. The fellowship is awarded annually to a first year, full-time graduate student obtaining their masters for work in the area of electrical engineering, at an engineering school/program of recognized standing worldwide"));
    }
}