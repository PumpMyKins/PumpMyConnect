package fr.pmc.core.servers;

public class ServerState {
	
	public enum State {
		
		ON,
		ON_FULL,
		ON_PRIME,
		ON_BETA,
		ON_DEV,
		WAITING,
		OFF;
		
		public static State fromString(String string) throws ParsingStateException {
			
			switch (string) {
				case "ON":
					return State.ON;
					
				case "ON_FULL":
					return State.ON_FULL;
					
				case "ON_PRIME":
					return State.ON_PRIME;
					
				case "ON_BETA":
					return State.ON_BETA;
					
				case "ON_DEV":
					return State.ON_DEV;
					
				case "WAITING":
					return State.WAITING;
					
				case "OFF":
					return State.OFF;

				default:
					throw new ParsingStateException(string);
			}
			
		}
		
		@Override
		public String toString() {
			return this.name();
		}
		
		public static class ParsingStateException extends Exception{

			private static final long serialVersionUID = -5592459649813581727L;

			public ParsingStateException(String string) {
				super(string);
			}
			
		}
		
	}
	
	private State state;
	private String raison;
	
	public ServerState(State state, String raison) {
		
		this.state = state;
		this.raison = raison;
		
	}

	public State getState() {
		return state;
	}

	public String getRaison() {
		return raison;
	}
	
}
