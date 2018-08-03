package com.example.shrung.blitzzsdk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shrung.blitzzsdk.R;
import com.example.shrung.blitzzsdk.listeners.Listener_OnLongClick;
import com.example.shrung.blitzzsdk.models.Model_Participants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Participants extends
        RecyclerView.Adapter<Adapter_Participants.ViewHolder_Participants> {

    private Context mContext;
    private ArrayList<Model_Participants.Participant> mParticipants;
    private Listener_OnLongClick mListenerOnLongClick;

    public Adapter_Participants(Context context,
                                ArrayList<Model_Participants.Participant> participants,
                                Listener_OnLongClick listenerOnLongClick){
        mContext = context;
        mParticipants = participants;
        mListenerOnLongClick = listenerOnLongClick;
    }

    @NonNull
    @Override
    public ViewHolder_Participants onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new ViewHolder_Participants(inflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Participants viewHolder_participants, final int i) {

        viewHolder_participants.bindData(mParticipants.get(i),mContext);

        viewHolder_participants.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                mListenerOnLongClick.onLongClick(mParticipants.get(i),i);

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mParticipants.size();
    }

    class ViewHolder_Participants extends RecyclerView.ViewHolder {

        private TextView mUsernameTv;
        private TextView mCompanyNameTv;
        private TextView mEmailTv;
        private ImageView mUserImage;

        ViewHolder_Participants(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_active_users, parent, false));

            mUsernameTv = itemView.findViewById(R.id.active_user_username);
            mCompanyNameTv = itemView.findViewById(R.id.active_user_company_name);
            mEmailTv = itemView.findViewById(R.id.active_user_email_id);
            mUserImage = itemView.findViewById(R.id.user_image);

        }

        private void bindData(Model_Participants.Participant participant, Context context) {
            if (participant != null) {
                mUsernameTv.setText(participant.getFULLNAME());
                mCompanyNameTv.setText(participant.getCOMPANY());
                mEmailTv.setText(participant.getUEMAIL());
                Picasso.with(context).load(participant.getPROFILEPIC()).into(mUserImage);
            }


        }


    }
}
