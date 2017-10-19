package entitiy;

/**
 * Created by marcel on 12.10.17.
 */
public class Resource {
	private ResourceType type;
	private Integer quality;

	public Resource(ResourceType type, Integer quality) {
		this.type = type;
		this.quality = quality;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Resource)) return false;

		Resource resource = (Resource) o;

		return type == resource.type && quality.equals(resource.quality);
	}

	@Override
	public int hashCode() {
		int result = type.hashCode();
		result = 31 * result + quality.hashCode();
		return result;
	}
}
