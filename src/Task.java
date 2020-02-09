
public class Task {

	// data members
	private String name;
	private String description;
	private int dueDate;
	private String complete = "Not Finished";

	// no argument constructor
	public Task() {

	}

	// constructor
	// if you make this first you have to
	// manually make the no argument constructor
	public Task(String name, String description, int dueDate) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;

	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", description=" + description + ", dueDate=" + dueDate + ", complete=" + complete
				+ "]";
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDueDate() {
		return dueDate;
	}

	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

}