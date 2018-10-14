/*
 * Copyright (C) 2018 AlexMofer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package am.project.x.business.others.opentypelist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import am.project.x.R;

/**
 * ViewHolder
 */
class OpenTypeListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView mVName;
    private final OnViewHolderListener mListener;
    private Object mItem;

    OpenTypeListViewHolder(@NonNull ViewGroup parent, OnViewHolderListener listener) {
        super(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_opentype_item, parent, false));
        mListener = listener;
        mVName = (TextView) itemView;
        itemView.setOnClickListener(this);
    }

    void bind(int position, OpenTypeListAdapterViewModel model) {
        mItem = model.getItem(position);
        mVName.setText(model.getItemName(mItem));
    }

    @Override
    public void onClick(View v) {
        mListener.onItemClick(getAdapterPosition(), mItem);
    }

    public interface OnViewHolderListener {
        void onItemClick(int position, Object item);
    }
}