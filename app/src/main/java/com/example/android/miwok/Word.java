package com.example.android.miwok;

public class Word {

    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudio;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    //Constructor with 2 strings and 1 imageResourceId
    public Word(String miwokTranslation, String defaultTranslation, int imageResourceId) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mImageResourceId = imageResourceId;
    }
    //change the order of parameters
    // Constructor with 2 strings and 1 imageResourceId
    public Word( int audio,String miwokTranslation, String defaultTranslation) {
        this.mMiwokTranslation = miwokTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mAudio = audio;
    }
    //Constructor with 2 Strings, 1 imageResourceId, 1 audio


    public Word(String mMiwokTranslation, String mDefaultTranslation, int mImageResourceId, int mAudio) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudio = mAudio;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){                        // -1 is not equal to -1 then it will return false
        return mImageResourceId != NO_IMAGE_PROVIDED; // because the expression evaluates to be false
    }

    public int getAudio() {        return mAudio;    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudio=" + mAudio +
                '}';
    }
}
