public class Movie implements Comparable<Movie> {
	private String title;
	private String category;

	public Movie(String title, String category) {
		this.title = title;
		this.category = category;
	}

	public String movieTitle() {
		return this.title;
	}

	public String movieCategory() {
		return this.category;
	}

	public void title(String title) {
		this.title = title;
	}

	public void category(String category) {
		this.category = category;
	}

	@Override
	public int compareTo(Movie o) {
		return this.title.compareTo(o.movieTitle());
	}

}