// Generated by view binder compiler. Do not edit!
package com.example.soalria.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.soalria.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAboutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView browser;

  @NonNull
  public final ImageView contact;

  @NonNull
  public final ImageView contact2;

  @NonNull
  public final ImageView imageAbout;

  @NonNull
  public final FrameLayout layoutAbout;

  @NonNull
  public final FrameLayout layoutAbout2;

  @NonNull
  public final ImageView location;

  @NonNull
  public final ImageView message;

  @NonNull
  public final TextView textViewAbout;

  @NonNull
  public final TextView textViewAboutDesc;

  @NonNull
  public final TextView textViewAboutjudul;

  @NonNull
  public final TextView textViewAddress;

  @NonNull
  public final TextView textViewAlamat;

  @NonNull
  public final TextView textViewAlamatDesc;

  @NonNull
  public final TextView textViewBrowser;

  @NonNull
  public final TextView textViewContact;

  @NonNull
  public final TextView textViewContact2;

  @NonNull
  public final TextView textViewKontak;

  @NonNull
  public final TextView textViewMessage;

  @NonNull
  public final TextView textViewOpen;

  @NonNull
  public final TextView textViewTime;

  @NonNull
  public final ImageView time;

  private FragmentAboutBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView browser,
      @NonNull ImageView contact, @NonNull ImageView contact2, @NonNull ImageView imageAbout,
      @NonNull FrameLayout layoutAbout, @NonNull FrameLayout layoutAbout2,
      @NonNull ImageView location, @NonNull ImageView message, @NonNull TextView textViewAbout,
      @NonNull TextView textViewAboutDesc, @NonNull TextView textViewAboutjudul,
      @NonNull TextView textViewAddress, @NonNull TextView textViewAlamat,
      @NonNull TextView textViewAlamatDesc, @NonNull TextView textViewBrowser,
      @NonNull TextView textViewContact, @NonNull TextView textViewContact2,
      @NonNull TextView textViewKontak, @NonNull TextView textViewMessage,
      @NonNull TextView textViewOpen, @NonNull TextView textViewTime, @NonNull ImageView time) {
    this.rootView = rootView;
    this.browser = browser;
    this.contact = contact;
    this.contact2 = contact2;
    this.imageAbout = imageAbout;
    this.layoutAbout = layoutAbout;
    this.layoutAbout2 = layoutAbout2;
    this.location = location;
    this.message = message;
    this.textViewAbout = textViewAbout;
    this.textViewAboutDesc = textViewAboutDesc;
    this.textViewAboutjudul = textViewAboutjudul;
    this.textViewAddress = textViewAddress;
    this.textViewAlamat = textViewAlamat;
    this.textViewAlamatDesc = textViewAlamatDesc;
    this.textViewBrowser = textViewBrowser;
    this.textViewContact = textViewContact;
    this.textViewContact2 = textViewContact2;
    this.textViewKontak = textViewKontak;
    this.textViewMessage = textViewMessage;
    this.textViewOpen = textViewOpen;
    this.textViewTime = textViewTime;
    this.time = time;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAboutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_about, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAboutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.browser;
      ImageView browser = ViewBindings.findChildViewById(rootView, id);
      if (browser == null) {
        break missingId;
      }

      id = R.id.contact;
      ImageView contact = ViewBindings.findChildViewById(rootView, id);
      if (contact == null) {
        break missingId;
      }

      id = R.id.contact2;
      ImageView contact2 = ViewBindings.findChildViewById(rootView, id);
      if (contact2 == null) {
        break missingId;
      }

      id = R.id.imageAbout;
      ImageView imageAbout = ViewBindings.findChildViewById(rootView, id);
      if (imageAbout == null) {
        break missingId;
      }

      id = R.id.layoutAbout;
      FrameLayout layoutAbout = ViewBindings.findChildViewById(rootView, id);
      if (layoutAbout == null) {
        break missingId;
      }

      id = R.id.layoutAbout2;
      FrameLayout layoutAbout2 = ViewBindings.findChildViewById(rootView, id);
      if (layoutAbout2 == null) {
        break missingId;
      }

      id = R.id.location;
      ImageView location = ViewBindings.findChildViewById(rootView, id);
      if (location == null) {
        break missingId;
      }

      id = R.id.message;
      ImageView message = ViewBindings.findChildViewById(rootView, id);
      if (message == null) {
        break missingId;
      }

      id = R.id.textViewAbout;
      TextView textViewAbout = ViewBindings.findChildViewById(rootView, id);
      if (textViewAbout == null) {
        break missingId;
      }

      id = R.id.textViewAboutDesc;
      TextView textViewAboutDesc = ViewBindings.findChildViewById(rootView, id);
      if (textViewAboutDesc == null) {
        break missingId;
      }

      id = R.id.textViewAboutjudul;
      TextView textViewAboutjudul = ViewBindings.findChildViewById(rootView, id);
      if (textViewAboutjudul == null) {
        break missingId;
      }

      id = R.id.textViewAddress;
      TextView textViewAddress = ViewBindings.findChildViewById(rootView, id);
      if (textViewAddress == null) {
        break missingId;
      }

      id = R.id.textViewAlamat;
      TextView textViewAlamat = ViewBindings.findChildViewById(rootView, id);
      if (textViewAlamat == null) {
        break missingId;
      }

      id = R.id.textViewAlamatDesc;
      TextView textViewAlamatDesc = ViewBindings.findChildViewById(rootView, id);
      if (textViewAlamatDesc == null) {
        break missingId;
      }

      id = R.id.textViewBrowser;
      TextView textViewBrowser = ViewBindings.findChildViewById(rootView, id);
      if (textViewBrowser == null) {
        break missingId;
      }

      id = R.id.textViewContact;
      TextView textViewContact = ViewBindings.findChildViewById(rootView, id);
      if (textViewContact == null) {
        break missingId;
      }

      id = R.id.textViewContact2;
      TextView textViewContact2 = ViewBindings.findChildViewById(rootView, id);
      if (textViewContact2 == null) {
        break missingId;
      }

      id = R.id.textViewKontak;
      TextView textViewKontak = ViewBindings.findChildViewById(rootView, id);
      if (textViewKontak == null) {
        break missingId;
      }

      id = R.id.textViewMessage;
      TextView textViewMessage = ViewBindings.findChildViewById(rootView, id);
      if (textViewMessage == null) {
        break missingId;
      }

      id = R.id.textViewOpen;
      TextView textViewOpen = ViewBindings.findChildViewById(rootView, id);
      if (textViewOpen == null) {
        break missingId;
      }

      id = R.id.textViewTime;
      TextView textViewTime = ViewBindings.findChildViewById(rootView, id);
      if (textViewTime == null) {
        break missingId;
      }

      id = R.id.time;
      ImageView time = ViewBindings.findChildViewById(rootView, id);
      if (time == null) {
        break missingId;
      }

      return new FragmentAboutBinding((ConstraintLayout) rootView, browser, contact, contact2,
          imageAbout, layoutAbout, layoutAbout2, location, message, textViewAbout,
          textViewAboutDesc, textViewAboutjudul, textViewAddress, textViewAlamat,
          textViewAlamatDesc, textViewBrowser, textViewContact, textViewContact2, textViewKontak,
          textViewMessage, textViewOpen, textViewTime, time);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}