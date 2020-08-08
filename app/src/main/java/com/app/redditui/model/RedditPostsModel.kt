package com.app.redditui.model


import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class RedditPostsModel(
    val `data`: Data?,
    val kind: String?
) : Parcelable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class Data(
        val after: String?,
        val before: String?,
        val children: List<Children?>?,
        val dist: Int?,
        val modhash: String?
    ) : Parcelable {
        @SuppressLint("ParcelCreator")
        @Parcelize
        data class Children(
            val `data`: Data?,
            val kind: String?
        ) : Parcelable {
            @SuppressLint("ParcelCreator")
            @Parcelize
            data class Data(
                val all_awardings: List<AllAwarding?>?,
                val allow_live_comments: Boolean?,
                val approved_at_utc: String?,
                val approved_by: String?,
                val archived: Boolean?,
                val author: String?,
                val author_flair_background_color: String?,
                val author_flair_css_class: String?,
                val author_flair_richtext: List<String?>?,
                val author_flair_template_id: String?,
                val author_flair_text: String?,
                val author_flair_text_color: String?,
                val author_flair_type: String?,
                val author_fullname: String?,
                val author_patreon_flair: Boolean?,
                val author_premium: Boolean?,
                val awarders: List<String?>?,
                val banned_at_utc: String?,
                val banned_by: String?,
                val can_gild: Boolean?,
                val can_mod_post: Boolean?,
                val category: String?,
                val clicked: Boolean?,
                val content_categories: String?,
                val contest_mode: Boolean?,
                val created: Double?,
                val created_utc: Double?,
                val crosspost_parent: String?,
                val crosspost_parent_list: List<CrosspostParent?>?,
                val discussion_type: String?,
                val distinguished: String?,
                val domain: String?,
                val downs: Int?,
                val edited: Boolean?,
                val gilded: Int?,
                val gildings: Gildings?,
                val hidden: Boolean?,
                val hide_score: Boolean?,
                val id: String?,
                val is_crosspostable: Boolean?,
                val is_meta: Boolean?,
                val is_original_content: Boolean?,
                val is_reddit_media_domain: Boolean?,
                val is_robot_indexable: Boolean?,
                val is_self: Boolean?,
                val is_video: Boolean?,
                val likes: String?,
                val link_flair_background_color: String?,
                val link_flair_css_class: String?,
                val link_flair_richtext: List<LinkFlairRichtext?>?,
                val link_flair_template_id: String?,
                val link_flair_text: String?,
                val link_flair_text_color: String?,
                val link_flair_type: String?,
                val locked: Boolean?,
                val media: Media?,
                val media_embed: MediaEmbed?,
                val media_only: Boolean?,
                val mod_note: String?,
                val mod_reason_by: String?,
                val mod_reason_title: String?,
                val mod_reports: List<String?>?,
                val name: String?,
                val no_follow: Boolean?,
                val num_comments: Int?,
                val num_crossposts: Int?,
                val num_reports: String?,
                val over_18: Boolean?,
                val parent_whitelist_status: String?,
                val permalink: String?,
                val pinned: Boolean?,
                val post_hint: String?,
                val preview: Preview?,
                val pwls: Int?,
                val quarantine: Boolean?,
                val removal_reason: String?,
                val removed_by: String?,
                val removed_by_category: String?,
                val report_reasons: String?,
                val saved: Boolean?,
                val score: Int?,
                val secure_media: SecureMedia?,
                val secure_media_embed: SecureMediaEmbed?,
                val selftext: String?,
                val selftext_html: String?,
                val send_replies: Boolean?,
                val spoiler: Boolean?,
                val stickied: Boolean?,
                val subreddit: String?,
                val subreddit_id: String?,
                val subreddit_name_prefixed: String?,
                val subreddit_subscribers: Int?,
                val subreddit_type: String?,
                val suggested_sort: String?,
                val thumbnail: String?,
                val thumbnail_height: Int?,
                val thumbnail_width: Int?,
                val title: String?,
                val top_awarded_type: String?,
                val total_awards_received: Int?,
                val treatment_tags: List<String?>?,
                val ups: Int?,
                val upvote_ratio: Double?,
                val url: String?,
                val url_overridden_by_dest: String?,
                val user_reports: List<String?>?,
                val view_count: String?,
                val visited: Boolean?,
                val whitelist_status: String?,
                val wls: Int?
            ) : Parcelable {
                @SuppressLint("ParcelCreator")
                @Parcelize
                data class AllAwarding(
                    val award_sub_type: String?,
                    val award_type: String?,
                    val coin_price: Int?,
                    val coin_reward: Int?,
                    val count: Int?,
                    val days_of_drip_extension: Int?,
                    val days_of_premium: Int?,
                    val description: String?,
                    val end_date: String?,
                    val giver_coin_reward: String?,
                    val icon_format: String?,
                    val icon_height: Int?,
                    val icon_url: String?,
                    val icon_width: Int?,
                    val id: String?,
                    val is_enabled: Boolean?,
                    val is_new: Boolean?,
                    val name: String?,
                    val penny_donate: String?,
                    val penny_price: String?,
                    val resized_icons: List<ResizedIcon?>?,
                    val resized_static_icons: List<ResizedStaticIcon?>?,
                    val start_date: String?,
                    val static_icon_height: Int?,
                    val static_icon_url: String?,
                    val static_icon_width: Int?,
                    val subreddit_coin_reward: Int?,
                    val subreddit_id: String?
                ) : Parcelable {
                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class ResizedIcon(
                        val height: Int?,
                        val url: String?,
                        val width: Int?
                    ) : Parcelable

                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class ResizedStaticIcon(
                        val height: Int?,
                        val url: String?,
                        val width: Int?
                    ) : Parcelable
                }

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class CrosspostParent(
                    val all_awardings: List<String?>?,
                    val allow_live_comments: Boolean?,
                    val approved_at_utc: String?,
                    val approved_by: String?,
                    val archived: Boolean?,
                    val author: String?,
                    val author_flair_background_color: String?,
                    val author_flair_css_class: String?,
                    val author_flair_richtext: List<String?>?,
                    val author_flair_template_id: String?,
                    val author_flair_text: String?,
                    val author_flair_text_color: String?,
                    val author_flair_type: String?,
                    val author_fullname: String?,
                    val author_patreon_flair: Boolean?,
                    val author_premium: Boolean?,
                    val awarders: List<String?>?,
                    val banned_at_utc: String?,
                    val banned_by: String?,
                    val can_gild: Boolean?,
                    val can_mod_post: Boolean?,
                    val category: String?,
                    val clicked: Boolean?,
                    val content_categories: String?,
                    val contest_mode: Boolean?,
                    val created: Double?,
                    val created_utc: Double?,
                    val discussion_type: String?,
                    val distinguished: String?,
                    val domain: String?,
                    val downs: Int?,
                    val edited: Boolean?,
                    val gilded: Int?,
                    val gildings: Gildings?,
                    val hidden: Boolean?,
                    val hide_score: Boolean?,
                    val id: String?,
                    val is_crosspostable: Boolean?,
                    val is_meta: Boolean?,
                    val is_original_content: Boolean?,
                    val is_reddit_media_domain: Boolean?,
                    val is_robot_indexable: Boolean?,
                    val is_self: Boolean?,
                    val is_video: Boolean?,
                    val likes: String?,
                    val link_flair_background_color: String?,
                    val link_flair_css_class: String?,
                    val link_flair_richtext: List<String?>?,
                    val link_flair_template_id: String?,
                    val link_flair_text: String?,
                    val link_flair_text_color: String?,
                    val link_flair_type: String?,
                    val locked: Boolean?,
                    val media: String?,
                    val media_embed: MediaEmbed?,
                    val media_only: Boolean?,
                    val mod_note: String?,
                    val mod_reason_by: String?,
                    val mod_reason_title: String?,
                    val mod_reports: List<String?>?,
                    val name: String?,
                    val no_follow: Boolean?,
                    val num_comments: Int?,
                    val num_crossposts: Int?,
                    val num_reports: String?,
                    val over_18: Boolean?,
                    val parent_whitelist_status: String?,
                    val permalink: String?,
                    val pinned: Boolean?,
                    val post_hint: String?,
                    val preview: Preview?,
                    val pwls: String?,
                    val quarantine: Boolean?,
                    val removal_reason: String?,
                    val removed_by: String?,
                    val removed_by_category: String?,
                    val report_reasons: String?,
                    val saved: Boolean?,
                    val score: Int?,
                    val secure_media: String?,
                    val secure_media_embed: SecureMediaEmbed?,
                    val selftext: String?,
                    val selftext_html: String?,
                    val send_replies: Boolean?,
                    val spoiler: Boolean?,
                    val stickied: Boolean?,
                    val subreddit: String?,
                    val subreddit_id: String?,
                    val subreddit_name_prefixed: String?,
                    val subreddit_subscribers: Int?,
                    val subreddit_type: String?,
                    val suggested_sort: String?,
                    val thumbnail: String?,
                    val thumbnail_height: Int?,
                    val thumbnail_width: Int?,
                    val title: String?,
                    val top_awarded_type: String?,
                    val total_awards_received: Int?,
                    val treatment_tags: List<String?>?,
                    val ups: Int?,
                    val upvote_ratio: Double?,
                    val url: String?,
                    val url_overridden_by_dest: String?,
                    val user_reports: List<String?>?,
                    val view_count: String?,
                    val visited: Boolean?,
                    val whitelist_status: String?,
                    val wls: String?
                ) : Parcelable {
                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    class Gildings(
                    ) : Parcelable

                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    class MediaEmbed(
                    ) : Parcelable

                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class Preview(
                        val enabled: Boolean?,
                        val images: List<Image?>?
                    ) : Parcelable {
                        @SuppressLint("ParcelCreator")
                        @Parcelize
                        data class Image(
                            val id: String?,
                            val resolutions: List<Resolution?>?,
                            val source: Source?,
                            val variants: Variants?
                        ) : Parcelable {
                            @SuppressLint("ParcelCreator")
                            @Parcelize
                            data class Resolution(
                                val height: Int?,
                                val url: String?,
                                val width: Int?
                            ) : Parcelable

                            @SuppressLint("ParcelCreator")
                            @Parcelize
                            data class Source(
                                val height: Int?,
                                val url: String?,
                                val width: Int?
                            ) : Parcelable

                            @SuppressLint("ParcelCreator")
                            @Parcelize
                            class Variants(
                            ) : Parcelable
                        }
                    }

                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    class SecureMediaEmbed(
                    ) : Parcelable
                }

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Gildings(
                    val gid_2: Int?
                ) : Parcelable

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class LinkFlairRichtext(
                    val e: String?,
                    val t: String?
                ) : Parcelable

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Media(
                    val oembed: Oembed?,
                    val reddit_video: RedditVideo?,
                    val type: String?
                ) : Parcelable {
                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class Oembed(
                        val description: String?,
                        val height: Int?,
                        val html: String?,
                        val provider_name: String?,
                        val provider_url: String?,
                        val thumbnail_height: Int?,
                        val thumbnail_url: String?,
                        val thumbnail_width: Int?,
                        val title: String?,
                        val type: String?,
                        val url: String?,
                        val version: String?,
                        val width: Int?
                    ) : Parcelable

                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class RedditVideo(
                        val dash_url: String?,
                        val duration: Int?,
                        val fallback_url: String?,
                        val height: Int?,
                        val hls_url: String?,
                        val is_gif: Boolean?,
                        val scrubber_media_url: String?,
                        val transcoding_status: String?,
                        val width: Int?
                    ) : Parcelable
                }

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class MediaEmbed(
                    val content: String?,
                    val height: Int?,
                    val scrolling: Boolean?,
                    val width: Int?
                ) : Parcelable

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class Preview(
                    val enabled: Boolean?,
                    val images: List<Image?>?
                ) : Parcelable {
                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class Image(
                        val id: String?,
                        val resolutions: List<Resolution?>?,
                        val source: Source?,
                        val variants: Variants?
                    ) : Parcelable {
                        @SuppressLint("ParcelCreator")
                        @Parcelize
                        data class Resolution(
                            val height: Int?,
                            val url: String?,
                            val width: Int?
                        ) : Parcelable

                        @SuppressLint("ParcelCreator")
                        @Parcelize
                        data class Source(
                            val height: Int?,
                            val url: String?,
                            val width: Int?
                        ) : Parcelable

                        @SuppressLint("ParcelCreator")
                        @Parcelize
                        class Variants(
                        ) : Parcelable
                    }
                }

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class SecureMedia(
                    val oembed: Oembed?,
                    val reddit_video: RedditVideo?,
                    val type: String?
                ) : Parcelable {
                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class Oembed(
                        val description: String?,
                        val height: Int?,
                        val html: String?,
                        val provider_name: String?,
                        val provider_url: String?,
                        val thumbnail_height: Int?,
                        val thumbnail_url: String?,
                        val thumbnail_width: Int?,
                        val title: String?,
                        val type: String?,
                        val url: String?,
                        val version: String?,
                        val width: Int?
                    ) : Parcelable

                    @SuppressLint("ParcelCreator")
                    @Parcelize
                    data class RedditVideo(
                        val dash_url: String?,
                        val duration: Int?,
                        val fallback_url: String?,
                        val height: Int?,
                        val hls_url: String?,
                        val is_gif: Boolean?,
                        val scrubber_media_url: String?,
                        val transcoding_status: String?,
                        val width: Int?
                    ) : Parcelable
                }

                @SuppressLint("ParcelCreator")
                @Parcelize
                data class SecureMediaEmbed(
                    val content: String?,
                    val height: Int?,
                    val media_domain_url: String?,
                    val scrolling: Boolean?,
                    val width: Int?
                ) : Parcelable
            }
        }
    }
}

class DiffUtilRedditPostsModelChildren: DiffUtil.ItemCallback<RedditPostsModel.Data.Children>() {
    override fun areItemsTheSame(oldItem: RedditPostsModel.Data.Children, newItem: RedditPostsModel.Data.Children): Boolean {
        return newItem == oldItem
    }

    override fun areContentsTheSame(oldItem: RedditPostsModel.Data.Children, newItem: RedditPostsModel.Data.Children): Boolean {
        return newItem == oldItem
    }
}