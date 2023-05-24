package rest.model;


public class PhotoResponse{ // POJO
	// Plain Old Java Object
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String thumbnailUrl;

	public int getAlbumId(){
		return albumId;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}
}