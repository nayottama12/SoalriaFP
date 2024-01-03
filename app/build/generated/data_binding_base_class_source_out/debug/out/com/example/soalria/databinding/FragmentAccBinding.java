// Generated by view binder compiler. Do not edit!
package com.example.soalria.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.soalria.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAccBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout FrameLayoutAcc;

  @NonNull
  public final Button buttonDeleteAcc;

  @NonNull
  public final Button buttonEditAcc;

  @NonNull
  public final CardView cardProfile;

  @NonNull
  public final ImageView imageProfile;

  @NonNull
  public final ImageView imageViewEmail;

  @NonNull
  public final ImageView imageViewPass;

  @NonNull
  public final ImageView imageViewPerson;

  @NonNull
  public final ImageView imageViewPhone;

  @NonNull
  public final FrameLayout layoutAbout2;

  @NonNull
  public final TextView textViewAcc;

  @NonNull
  public final TextView textViewAccEmail1;

  @NonNull
  public final TextView textViewAccEmail2;

  @NonNull
  public final TextView textViewAccPass1;

  @NonNull
  public final TextView textViewAccPass2;

  @NonNull
  public final TextView textViewAccPerson;

  @NonNull
  public final TextView textViewAccPerson2;

  @NonNull
  public final TextView textViewAccPhone1;

  @NonNull
  public final TextView textViewAccPhone2;

  private FragmentAccBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout FrameLayoutAcc,
      @NonNull Button buttonDeleteAcc, @NonNull Button buttonEditAcc, @NonNull CardView cardProfile,
      @NonNull ImageView imageProfile, @NonNull ImageView imageViewEmail,
      @NonNull ImageView imageViewPass, @NonNull ImageView imageViewPerson,
      @NonNull ImageView imageViewPhone, @NonNull FrameLayout layoutAbout2,
      @NonNull TextView textViewAcc, @NonNull TextView textViewAccEmail1,
      @NonNull TextView textViewAccEmail2, @NonNull TextView textViewAccPass1,
      @NonNull TextView textViewAccPass2, @NonNull TextView textViewAccPerson,
      @NonNull TextView textViewAccPerson2, @NonNull TextView textViewAccPhone1,
      @NonNull TextView textViewAccPhone2) {
    this.rootView = rootView;
    this.FrameLayoutAcc = FrameLayoutAcc;
    this.buttonDeleteAcc = buttonDeleteAcc;
    this.buttonEditAcc = buttonEditAcc;
    this.cardProfile = cardProfile;
    this.imageProfile = imageProfile;
    this.imageViewEmail = imageViewEmail;
    this.imageViewPass = imageViewPass;
    this.imageViewPerson = imageViewPerson;
    this.imageViewPhone = imageViewPhone;
    this.layoutAbout2 = layoutAbout2;
    this.textViewAcc = textViewAcc;
    this.textViewAccEmail1 = textViewAccEmail1;
    this.textViewAccEmail2 = textViewAccEmail2;
    this.textViewAccPass1 = textViewAccPass1;
    this.textViewAccPass2 = textViewAccPass2;
    this.textViewAccPerson = textViewAccPerson;
    this.textViewAccPerson2 = textViewAccPerson2;
    this.textViewAccPhone1 = textViewAccPhone1;
    this.textViewAccPhone2 = textViewAccPhone2;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAccBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAccBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_acc, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAccBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout FrameLayoutAcc = (FrameLayout) rootView;

      id = R.id.buttonDeleteAcc;
      Button buttonDeleteAcc = ViewBindings.findChildViewById(rootView, id);
      if (buttonDeleteAcc == null) {
        break missingId;
      }

      id = R.id.buttonEditAcc;
      Button buttonEditAcc = ViewBindings.findChildViewById(rootView, id);
      if (buttonEditAcc == null) {
        break missingId;
      }

      id = R.id.cardProfile;
      CardView cardProfile = ViewBindings.findChildViewById(rootView, id);
      if (cardProfile == null) {
        break missingId;
      }

      id = R.id.imageProfile;
      ImageView imageProfile = ViewBindings.findChildViewById(rootView, id);
      if (imageProfile == null) {
        break missingId;
      }

      id = R.id.imageViewEmail;
      ImageView imageViewEmail = ViewBindings.findChildViewById(rootView, id);
      if (imageViewEmail == null) {
        break missingId;
      }

      id = R.id.imageViewPass;
      ImageView imageViewPass = ViewBindings.findChildViewById(rootView, id);
      if (imageViewPass == null) {
        break missingId;
      }

      id = R.id.imageViewPerson;
      ImageView imageViewPerson = ViewBindings.findChildViewById(rootView, id);
      if (imageViewPerson == null) {
        break missingId;
      }

      id = R.id.imageViewPhone;
      ImageView imageViewPhone = ViewBindings.findChildViewById(rootView, id);
      if (imageViewPhone == null) {
        break missingId;
      }

      id = R.id.layoutAbout2;
      FrameLayout layoutAbout2 = ViewBindings.findChildViewById(rootView, id);
      if (layoutAbout2 == null) {
        break missingId;
      }

      id = R.id.textViewAcc;
      TextView textViewAcc = ViewBindings.findChildViewById(rootView, id);
      if (textViewAcc == null) {
        break missingId;
      }

      id = R.id.textViewAccEmail1;
      TextView textViewAccEmail1 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccEmail1 == null) {
        break missingId;
      }

      id = R.id.textViewAccEmail2;
      TextView textViewAccEmail2 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccEmail2 == null) {
        break missingId;
      }

      id = R.id.textViewAccPass1;
      TextView textViewAccPass1 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccPass1 == null) {
        break missingId;
      }

      id = R.id.textViewAccPass2;
      TextView textViewAccPass2 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccPass2 == null) {
        break missingId;
      }

      id = R.id.textViewAccPerson;
      TextView textViewAccPerson = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccPerson == null) {
        break missingId;
      }

      id = R.id.textViewAccPerson2;
      TextView textViewAccPerson2 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccPerson2 == null) {
        break missingId;
      }

      id = R.id.textViewAccPhone1;
      TextView textViewAccPhone1 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccPhone1 == null) {
        break missingId;
      }

      id = R.id.textViewAccPhone2;
      TextView textViewAccPhone2 = ViewBindings.findChildViewById(rootView, id);
      if (textViewAccPhone2 == null) {
        break missingId;
      }

      return new FragmentAccBinding((FrameLayout) rootView, FrameLayoutAcc, buttonDeleteAcc,
          buttonEditAcc, cardProfile, imageProfile, imageViewEmail, imageViewPass, imageViewPerson,
          imageViewPhone, layoutAbout2, textViewAcc, textViewAccEmail1, textViewAccEmail2,
          textViewAccPass1, textViewAccPass2, textViewAccPerson, textViewAccPerson2,
          textViewAccPhone1, textViewAccPhone2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}