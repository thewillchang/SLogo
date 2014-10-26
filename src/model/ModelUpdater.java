package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import transitionstate.TransitionState;
import turtle.Turtle;

public class ModelUpdater {
	
	public Map<Turtle, List<TransitionState>> updateModel(Collection<Turtle> turtles, List<TransitionState> states) {
		Map<Turtle, List<TransitionState>> mapping = createTurtleTransitionMapping(turtles, states);
		return mapping;
	
	}
	
	private Map<Turtle, List<TransitionState>> createTurtleTransitionMapping(Collection<Turtle> turtles, List<TransitionState> states) {
		Map<Turtle, List<TransitionState>> mapping = new HashMap<>();
		Collection<Turtle> selected = new HashSet<>(findSelectedTurtles(turtles));
		Set<Turtle> turtlesToMove;
		for (TransitionState state : states) {
			turtlesToMove = new HashSet<>();
			if (state.getTurtles().isEmpty()) {
				turtlesToMove = new HashSet<>(selected);
			} else {
				for (Turtle turtle : selected) {
					if (state.getTurtles().contains(turtle.getId())) {
						turtlesToMove.add(turtle);
					}
				}
			}
			for (Turtle turtle : turtlesToMove) {
				mapping.putIfAbsent(turtle, new ArrayList<>());
				mapping.get(turtle).add(state);
			}
		}
		return mapping;
	}
	
	private Collection<Turtle> findSelectedTurtles(Collection<Turtle> turtles) {
		Collection<Turtle> selected = new ArrayList<>();
		for (Turtle turtle : turtles) {
			if (turtle.isSelected()) {
				selected.add(turtle);
			}
		}
		return selected;
	}
	
}
